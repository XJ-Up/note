package com.xiajun.kt;

/**
 * Created by ChenS on 2019/6/6.
 * chenshichao@outlook.com
 */
public class java调用kotlin静态伴生对象 {

    public String name = "freddy";

    public static void main(String[] args) {

        Static.Obj.INSTANCE.test();

        Obj.INSTANCE.setStat(1);
        System.out.println(Obj.INSTANCE.getStat());
        Obj.INSTANCE.setStat(2);
        System.out.println(Obj.INSTANCE.getStat());
        Obj.INSTANCE.testStatic();

        System.out.println(HalfStatic.Companion.name() + HalfStatic.Companion.getAge());
    }

    public void javaToKotlin() {
        System.out.println("kotlin调用java");
    }
}
