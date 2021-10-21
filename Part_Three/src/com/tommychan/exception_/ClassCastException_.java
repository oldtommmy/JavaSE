package com.tommychan.exception_;

public class ClassCastException_ {
    public static void main(String[] args) {
        A b = new B(); //向上转型
        B b1 = (B) b;   //向下转型
        C b2 = (C) b; //ClassCastException
    }
}

class A{}
class B extends A{}
class C extends A{}