package com.tommychan.learning.abstractDetails;

public class AbstractDetails02 {
    public static void main(String[] args) {

    }
}

abstract class C{
    //抽象类可以有任意成员【抽象类本质还是类】，比如类中可含有：非抽象方法、构造器、静态属性等等

    private int age;
    public static int id;
    public void Show(){

    }

    public C(int age) {
        this.age = age;
    }

    abstract public void Test(); //抽象方法不能有主体，即不能实现
    //abstract public void Test(){};
}

class D extends C{  //如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法，除非它自己也声明为abstract类。
    @Override
    public void Test(){
        System.out.println("Test is called");
    }

    public D(int age) {
        super(age);
    }
}

abstract class E extends C{  //如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法，除非它自己也声明为abstract类。
    public E(int age) {
        super(age);
    }
}

//抽象方法不能使用private、final 和 static来修饰，因为子类需要重写抽象方法，而这些关键字都是和重写相违背的

abstract class F{
    abstract public void hi();
    //abstract private void hi();
    //abstract final void hi();
    //abstract static void hi();
}