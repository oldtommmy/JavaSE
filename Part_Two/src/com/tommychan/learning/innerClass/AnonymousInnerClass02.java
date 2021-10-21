package com.tommychan.learning.innerClass;

public class AnonymousInnerClass02 { //外部其他类
    public static void main(String[] args) {
        Outer03 outer03 = new Outer03();
        outer03.method3_1();
        System.out.println("==========");
        outer03.method3_2();
    }
}

class Outer03 { //外部类
    private int n2 = 10;
    //基于类的匿名内部类的使用
    public void method3_1() {
        //(1)father编译类型：Father 运行类型：Outer03$1
        //(2)底层创建的匿名内部类
        /*
            class Outer03$1 extends Father {

            }
        */
        //(3)return 了Outer03$1的对象的地址
        Father father = new Father("Mike"){

        };
        System.out.println("father's object = "+father.getClass());
        father.method_B(); //调用方式 第一种 因为匿名内部类是一个类
        //调用方式 第二种 因为匿名内部类是一个对象
        //Father father = new Father("Mike"){
        //
        //}.method_B();
    }
    //基于抽象类的匿名内部类的使用
    public void method3_2(){
        AbstractFather abstractFather = new AbstractFather() {
            @Override
            public void method_C() {
                System.out.println("public void method_C() is called");
            }
        };
        System.out.println("abstractFather's object = "+abstractFather.getClass());
        abstractFather.method_C();
    }
}

class Father{
    private String name;

    public Father(String name) {
        this.name = name;
    }

    public void method_B(){
        System.out.println("public void method_B() is called");
    }
}

abstract class AbstractFather{
    public abstract void method_C();
}