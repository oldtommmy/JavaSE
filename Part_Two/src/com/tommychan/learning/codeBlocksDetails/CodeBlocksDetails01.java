package com.tommychan.learning.codeBlocksDetails;

public class CodeBlocksDetails01 {
    public static void main(String[] args) {
        B b = new B();
    }
}

class B{
//创建一个对象时，在一个类调用顺序是：
//    (1)调用静态代码块和静态属性初始化
//    注意：静态代码块 和 静态属性初始化 调用的优先级一样，如果有多个静态代码块和多个静态变量初始化，则按他们定义的顺序调用
//    (2)调用普通代码块和普通属性的初始化
//    注意：普通代码块和普通属性初始化调用的优先级一样，如果有多个普通代码块和多个普通属性初始化，则按定义顺序调用
//    (3)调用构造方法

    public static int n1 = getN1(); //静态属性（静态变量）初始化

    static {                        //静态代码块
        System.out.println("static codeblocks is called");
    };

    public static int getN1(){
        System.out.println("getN1() is called");
        return 10;
    }

    {                                //普通代码块
        System.out.println("normal codeblocks is called");
    };

    private int n2 = getN2();        //普通属性初始化

    public int getN2() {
        System.out.println("getN2() is called");
        return 20;
    }

    public B() {                     //构造方法
        System.out.println("Constructor_B is called");
    }
}