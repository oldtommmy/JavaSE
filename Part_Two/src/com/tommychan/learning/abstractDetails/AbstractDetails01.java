package com.tommychan.learning.abstractDetails;

public class AbstractDetails01 {
    public static void main(String[] args) {
//        new A();  抽象类不能被实例化

    }
}

abstract class A{
//    抽象类不一定要包含abstract方法,也就是说,抽象类可以没有abstract方法
}

abstract class B{
    abstract public void Show(); //一旦类包含了abstract方法，则这个类必须声明为abstract
    //abstract private int age; abstract只能修饰类和方法，不能修饰属性和其它的
}