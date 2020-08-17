
# 实际开发流程 

- ### 创建git仓库 此处以 国内 码云仓库为例

  1. 申请 码云仓库账号（进入  <https://gitee.com/>  申请账号并登陆）

  2. 登陆账号 创建 git仓库 

    ![输入图片说明](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314134006749.png "在这里输入图片标题")

  3. 进入创建仓库页面 填写 信息![20200314134135683](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314134135683.png)

  4. 进入创建好的仓库 进行克隆地址复制![20200314134224167](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314134224167.png)

  5. 本地克隆

     ![20200314134341355](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314134341355.png)

     桌面创建文件夹

     ![20200314134411913](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314134411913.png)

     进入文件夹 输入 cmd 回车（ 注意：此教程是在安装了 git工具后操作）![20200314134449563](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314134449563.png)

     在此页面输入： git clone  刚才复制的地址  回车，这时仓库里的文件就被拉了下来（注意：如果是第一次clone可能需要 输入账户和密码（码云的账号和密码））

     到此我们本地就和远程仓库建立了联系

  6. 当我们把要编辑的 代码 完成后 就要进行代码的提交了 ，这里我们 创建一个文件进行测试 （注意：这个文件要放到刚才拉下来的文件夹下面） 

     ![20200314134621594](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314134621594.png)

  7. 我们开始提交代码 

     ![20200314134652103](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314134652103.png)在文件夹上输入 cmd 进入命令行

     ![20200314134710711](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314134710711.png)首先，我们输入 git status 查看当前状态，可以看到我们有一个文件没有提交

     ![20200314134732764](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314134732764.png)接下来我们输入  git add . (https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res注意：空格)把文件加入本地 git缓存

     ![20200314134752871](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314134752871.png)当文件被添加到 git本地缓存中时 ，我们就可以进行提交了 输入 git commit -m '这是提交备注信息'  

     ![20200314134817988](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314134817988.png)最后 我们把本地文件 提交到 远程仓库  输入 ：git push ，到此 ，本地文件就同步到远程仓库了。

     ![20200314134838318](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314134838318.png)

     - # 进阶（上面适合我们自己管理自己创建的仓库，下面是在公司实际开发中的一些操作）

       #####  我们在实际开发中是不被允许直接提交到 主分支 的 ，所以我们需要创建 子分支 。

       ![2020031413492952](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/2020031413492952.png)

       进入

       ![20200314134945291](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314134945291.png)

       输入 分支名称 进行 创建 

       ![20200314135006509](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314135006509.png)

       #### 当我们需要在此分支开发时，只需要通过 命令行 输入 git pull ，把远程分支拉下来  ，然后切换到我们创建的分支 git checkout test(https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res我们创建的分支名称)

       ![20200314135038479](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314135038479.png)这时我们就可以进行开发了 ，。。。。。开发完成了，提交代码。

       ![20200314135057274](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res\20200314135057274.png)步骤和前面的相同。我们查看下 ，进入 test分支  发现 有我们提交的文件，而进入 主分支 没有提交文件 （进入分支方法 在前面创建分支页面点击分支名称即可）

       test分支

       ![20200314135117101](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314135117101.png)

       master 分支 （主分支）

       ![20200314135142210](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314135142210.png)

       - 当我们确定 子分支 上的代码没有问题我们就可以 合并到 主分支 了。

         ![20200314135200561](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314135200561.png)

         这时我们在看看仓库情况

         ![20200314135225663](https://gitee.com/xj36/android_knowledge_base/raw/master/%E5%BC%80%E5%8F%91%E9%80%9A%E7%94%A8%E7%9F%A5%E8%AF%86/%E4%BB%A3%E7%A0%81%E7%AE%A1%E7%90%86/Git/res/20200314135225663.png)主分支里也有了 我们提交的文件。

         到此，我们就已经完成一遍代码管理的流程。