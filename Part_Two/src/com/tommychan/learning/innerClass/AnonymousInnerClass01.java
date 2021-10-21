package com.tommychan.learning.innerClass;

public class AnonymousInnerClass01 { //外部其他类
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.method2_1();
    }
}

class Outer02 { //外部类
    private int n1 = 10;

    public void method2_1() {
        //基于接口的匿名内部类  需求 ： 有些类只想使用一次，为了避免重新写一个类，采用匿名内部类
        Inter_A Annoy01 = new Inter_A() {   //(1)Annoy01 编译类型：Inter_A 运行类型：匿名内部类
            public void method_A() {
                System.out.println("public void method_A() is called");
            }                   //(2)jdk在底层创建了匿名内部类 Outer02$1，
        };                      //   并立即创建Outer02$1实例，把地址返回给Annoy01
        Annoy01.method_A();     //(3)匿名内部类只能使用一次，但是实例化的对象可以多次使用
        Annoy01.method_A();     //底层生成的内部类：
        Annoy01.method_A();     // class Outer02$1 implements Inter_A{
    }                           //    @override
}                               //    public void method_A(){
                                //        System.out.println("public void method_A() is called");
                                //    }
                                //}

interface Inter_A{
    public void method_A();
}