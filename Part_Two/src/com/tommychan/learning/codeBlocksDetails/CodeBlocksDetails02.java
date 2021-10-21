package com.tommychan.learning.codeBlocksDetails;

public class CodeBlocksDetails02 {
    public static void main(String[] args) {
        D d = new D();
    }
}

class C {
    public C() {
        //存在隐藏的执行要求
        //(1)super() -> 去找C的父类 Object
        //(2)调用本类的普通代码块
        System.out.println("Constructor_C is called");
    }

    {
        System.out.println("Normal codeblocks of C is called");
    };
}

class D extends C {
    public D() {
        //存在隐藏的执行要求
        //(1)隐含的super() -> 去找D的父类 C
        //(2)调用本类的普通代码块
        System.out.println("Constructor_D is called");
    }

    {
        System.out.println("Normal codeblocks of D is called");
    };
}