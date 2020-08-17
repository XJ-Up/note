# Android事件分发  分析

## 什么是事件的 分发

> 用户通过屏幕与手机交互的时候，每一次点击、长按、移动等都是一个事件。

>事件分发机制：某一个事件从屏幕传递各个View,由View来使用这一事件（消费是事件）或者忽略这一事件（不消费事件），这整个过程的控制。

## 事件分发的对象是谁

> 系统把事件封装为MotionEvent对象，事件分发的过程就是MotionEvent分发的过程。

## 事件类型

> 按下（ACTION _DOWN）

> 移动 （ACTION_MOVE）

> 抬起 （ACTION_UP）

> 取消 （ACTION_CANUCEL）

## 事件序列

> 从手指按下屏幕开始，到手指离开屏幕所产生的一系列事件。

## 传递层级

> Activity ->Window ->DecorView -> ViewGroup ->View

## 主要传递对象及顺序

> Activity 、 ViewGroup、 View

## Activity中

> dispatchTouchEvent(MotionEvent ev)

> onTouchEvent(MotionEvent event)

![Activity事件分发流程图](C:\Users\13262\Desktop\个人学习\Activity事件分发流程图.png)

## ViewGroup中

> dispatchTouchEvent(MotionEvent ev)

> onInterceptTouchEvent(MotionEvent ev)

> onTouchEvent(MotionEvent event)

![ViewGroup事件分发流程图](C:\Users\13262\Desktop\个人学习\ViewGroup事件分发流程图.png)

## View中

> dispatchTouchEvent(MotionEvent ev)

> onTouchEvent(MotionEvent event)

![View事件分发流程图](C:\Users\13262\Desktop\个人学习\View事件分发流程图.png)

## 验证 （事件传递流程）

### 代码测试

MainActivity 

``` java

public class MainActivity extends AppCompatActivity {
    /**
     * ViewsGroup：dispatchTouchEvent
     * 1.去判断是否需要拦截事件
     * 2.在当前ViewGroup中找到用户真正点击的View
     * 3.分发事件到View上
     * @param savedInstanceState
     */
     public static  final  String TAG="测试";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG,"MainActivity：dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"MainActivity：onTouchEvent");
        return super.onTouchEvent(event);
    }
}
```



MyViewGroup

``` java
public class MyViewGroup extends FrameLayout {
    public MyViewGroup(@NonNull Context context) {
        super(context);
    }

    public MyViewGroup(@NonNull Context context, @NonNull AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(@NonNull Context context, @NonNull AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyViewGroup(@NonNull Context context, @NonNull AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG,"MyViewGroup：dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG,"MyViewGroup : onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"MyViewGroup：onTouchEvent");
        return super.onTouchEvent(event);
    }

}
```

MyView

``` java
public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG,"MyView：dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"MyView：onTouchEvent");
        return super.onTouchEvent(event);

    }
}
```

### 布局

```xml
<?xml version="1.0" encoding="utf-8"?>
<com.example.a13262.myapplication.MyViewGroup xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:background="#ff0000">

    <com.example.a13262.myapplication.MyView
        android:layout_width="250dp"
        android:layout_height="250dp"
        android:background="#000"
       />

</com.example.a13262.myapplication.MyViewGroup>
```



> 运行

![事件分发](C:\Users\13262\Desktop\个人学习\事件分发.gif)

## 默认传递流程

> MainActivity：dispatchTouchEvent ---> MyViewGroup：dispatchTouchEvent --->MyViewGroup : onInterceptTouchEvent---> 	MyView：dispatchTouchEvent --->MyView：onTouchEvent ---> MyViewGroup：onTouchEvent --->MainActivity：onTouchEvent

同一个事件序列，如果子View（ViewGroup） 没有处理事件（没有消费事件），那么后续事件就不会再传递到子View中。

> MainActivity：dispatchTouchEvent --->MainActivity：onTouchEven

## 验证 （cancel事件）

### 代码测试

MainActivity

```java
public class MainActivity extends AppCompatActivity {
    /**
     * ViewsGroup：dispatchTouchEvent
     * 1.去判断是否需要拦截事件
     * 2.在当前ViewGroup中找到用户真正点击的View
     * 3.分发事件到View上
     * @param savedInstanceState
     */
     public static  final  String TAG="测试";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG,"MainActivity：dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"MainActivity：onTouchEvent");
        return super.onTouchEvent(event);
    }
}
```

MyScrollView 

``` java
public class MyScrollView extends ScrollView {
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean b = super.onInterceptTouchEvent(ev);
        Log.e(TAG,"MyScrollView：onInterceptTouchEvent---------------"+b);
        return  b;
    }

}
```

MyButton

``` java
public class MyButton extends AppCompatButton {

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"MyButton：onTouchEvent---------------"+event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG,"MyButton：dispatchTouchEvent---------------"+event.getAction());
        return super.dispatchTouchEvent(event);
    }
}
```



### 布局

``` xml
<?xml version="1.0" encoding="utf-8"?>
1<com.example.a13262.myapplication.MyScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:background="#fc0000">
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <com.example.a13262.myapplication.MyButton
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:text="测试取消事件"
            />
        <TextView
            android:layout_width="match_parent"
            android:layout_height="5000dp" />
    </LinearLayout>

</com.example.a13262.myapplication.MyScrollView>
```

> 运行

![验证Cancel事件](C:\Users\13262\Desktop\个人学习\验证Cancel事件.gif)

## 验证（ ViewGroup事件拦截）

### 代码测试

MainActivity

``` java
public class MainActivity extends AppCompatActivity {
    /**
     * ViewsGroup：dispatchTouchEvent
     * 1.去判断是否需要拦截事件
     * 2.在当前ViewGroup中找到用户真正点击的View
     * 3.分发事件到View上
     * @param savedInstanceState
     */
     public static  final  String TAG="测试";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG,"MainActivity：dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"MainActivity：onTouchEvent");
        return super.onTouchEvent(event);
    }
}
```

MyViewGroup

```java
public class MyViewGroup extends FrameLayout {
    public MyViewGroup(@NonNull Context context) {
        super(context);
    }

    public MyViewGroup(@NonNull Context context, @NonNull AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(@NonNull Context context, @NonNull AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyViewGroup(@NonNull Context context, @NonNull AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG,"MyViewGroup：dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG,"MyViewGroup : onInterceptTouchEvent");
        //返回 true 标志事件被拦截不会传递到MyView中去了
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"MyViewGroup：onTouchEvent");
        Log.e(TAG,"MyViewGroup：正在处理事件");
        return  true;
    }

}
```

MyView

```java
public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG,"MyView：dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"MyView：onTouchEvent");
        return super.onTouchEvent(event);

    }
}
```

### 布局

```xml
<?xml version="1.0" encoding="utf-8"?>
<com.example.a13262.myapplication.MyViewGroup xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:background="#ff0000">

    <com.example.a13262.myapplication.MyView
        android:layout_width="250dp"
        android:layout_height="250dp"
        android:background="#000"
       />

</com.example.a13262.myapplication.MyViewGroup>
```

> 运行

![验证ViewGroup拦截事件](C:\Users\13262\Desktop\个人学习\验证ViewGroup拦截事件.gif)

### 可以看出事件没有进入MyView中

