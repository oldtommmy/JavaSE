package com.tommychan.learning.interface_.exercise01;

public class Test01 {
    public static void main(String[] args) {
        C c = new C();
        c.show();
    }
}

interface A{
    int x = 1;     //等价为 public static final int x = 1;
}

class B{
    int x = 0;     //普通属性
}

class C extends B implements A{
    public void show(){
        //System.out.println(x); 编译错误，x不明确
        System.out.println(super.x); //访问父类的x 则用super.x来指明
        System.out.println(A.x); //访问接口的x 则用接口名.x指明
    }
}