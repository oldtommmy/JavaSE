package com.tommychan.learning.mainDetails;

//import sun.applet.Main;

public class MainDetails1 {
    public static void main(String[] args) {
        Method1();
        MainDetails1.Method1();
        //Method2(); 不能直接访问该类中的非静态成员
        //必须创建该类的一个实例对象后，才能通过这个对象去访问类中的非静态成员
        MainDetails1 mainDetails1 = new MainDetails1();
        mainDetails1.Method2();

        //在IDEA下如何传入参数到main函数里
        for (int i = 0; i < args.length; i++) {
            System.out.println("第"+i+"个参数："+args[i]);
        }

    }
    //在main（）方法中，我们可以直接调用main方法所在类的静态方法或静态属性。
    public static void Method1(){
        System.out.println("Method1 is called");
    }

    //不能直接访问该类中的非静态成员，必须创建该类的一个实例对象后，才能通过这个对象去访问类中的非静态成员
    public void Method2(){
        System.out.println("Method2 is called");
    }
}
