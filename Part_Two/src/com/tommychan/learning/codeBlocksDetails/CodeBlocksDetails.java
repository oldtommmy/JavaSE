package com.tommychan.learning.codeBlocksDetails;

public class CodeBlocksDetails {
    public static void main(String[] args) {

        //如果只是使用类的静态成员时，因为存在类的加载，类代码块会执行，普通代码块并不会执行。
        System.out.println("static n = "+A.n);
        System.out.println("===============");
        //普通的代码块，在创建对象实例时，会被隐式的调用。被创建一次，就会调用一次。
        //而此时因为类已经加载完毕，类代码块将不再执行
        A a = new A();
        A a1 = new A();
    }
}

class A{
    public static int n = 10;

    static {
        System.out.println("static codeblocks is called");
    }

    {
        System.out.println("codeblocks is called");
    }
}