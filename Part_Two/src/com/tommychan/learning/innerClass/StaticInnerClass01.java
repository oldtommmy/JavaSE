package com.tommychan.learning.innerClass;

public class StaticInnerClass01 {
    public static void main(String[] args) {
        Outer06 outer06 = new Outer06();
        outer06.method6_2();
        //外部其他类——访问———＞静态内部类访问方式：创建对象，再访问
        //(1)
        Outer06.Inner_D inner_d = new Outer06.Inner_D();
        inner_d.method6_1();
        //(2)编写方法返回类
        Outer06.Inner_D inner_d1 = outer06.getInner_D();
    }
}

class Outer06{
    private int n4 = 10;
    private static String name = "xxx";

    static class Inner_D{
        private static String name = "yyy";
        public void method6_1(){
            System.out.println("static String="+name);//可以直接访问外部类的所有静态成员，包含私有的
            System.out.println("Outer String ="+Outer06.name);//外部类和静态内部类的成员重名时
            //System.out.println("n1="+n1);但不能直接访问非静态成员
            //静态内部类---访问---＞外部类（比如：静态属性） [访问方式：直接访问所有静态成员]
        }
    }

    public Inner_D getInner_D(){
        return new Inner_D();
    }
    //作用域：同其他的成员，为整个类体
    //外部类——访问———＞静态内部类访问方式：创建对象，再访问
    public void method6_2(){
        Inner_D inner_d = new Inner_D();
        inner_d.method6_1();
    }
}