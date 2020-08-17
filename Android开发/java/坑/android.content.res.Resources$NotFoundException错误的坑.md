#### 2020/5/14

> 今天偶遇 android.content.res.Resources$NotFoundException: BUG可让我一顿好找。特此记录！

场景还原：

在RecyclerView  Adapter中获取布局崩溃 ，起初查网上说的是

1. R文件的问题，有的说删除

![1589451116825](C:\Users\13262\AppData\Local\Temp\1589451116825.png)

当我删除后依旧不行。。。。。。

2.inflate 文件的时候 R.Layout.****, 写成了R.id.*****  这种很显然不是。。。

3.文本渲染的时候 tv.setTest(),传了 int 类型   还没有执行文本渲染

4.布局文件存放文件加错误 。我只有一个文件夹 。。。

5.更有甚者 说 AS的问题，我把AS重装了 历时 一个半小时 。。。 没用

好了网上方法都试了没用 

我都快放弃了，突然想到在没有使用本地json测试的时候是好的 ，我考虑是数据的问题，然而数据是好的Log有显示 。我放弃了。

我把我的代码发给了一位大佬，起初把大佬也难住了，后来经过大佬的一步步测试，原来我一直信任的json本地获取数据这块出问题了，

原来：

```java
 /**
     * 读取assets目录下的文件,并返回字符串
     */
    public static String getAssetsFile(String name) {
        InputStream is = null;
        BufferedInputStream bis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        StringBuilder stringBuilder = null;
        final AssetManager assetManager = Latte.getApplicationContext().getAssets();
        try {
            is = assetManager.open(name);
            bis = new BufferedInputStream(is);
            isr = new InputStreamReader(bis);
            br = new BufferedReader(isr);
            stringBuilder = new StringBuilder();
            String str;
            while ((str = br.readLine()) != null) {
                stringBuilder.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (is != null) {
                    is.close();
                }
//                assetManager.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (stringBuilder != null) {
            return stringBuilder.toString();
        } else {
            return null;
        }
    }
```

这个代码出了问题，我在读取本地json文件后顺手把   assetManager 给 close 了，这个是布局绘制时获取信息的管理器，我给关闭了 ，布局自然找不到。。。。到此。这个bug解决了。

### 心累！

