package com.tommychan.learning.innerClass;

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01(10);
        outer01.method1();
    }
}
class Outer01{ //外部类
    private int n1;
    private void method(){
        System.out.println("private void method() is called");
    }

    public Outer01(int n1) {
        this.n1 = n1;
    }

    public void method1(){ //2.不能添加访问修饰符，因为它的地位就是一个局部变量，但是可以使用final修饰
                           //2.用final修饰后则不能被继承
        class Inner01{ //局部内部类--在方法中
            //3.作用域：仅仅在定义它的方法或代码块中
            //4.局部内部类—访问—＞外部类的成员  访问方式：直接访问 如下
            public void method02(){
                System.out.println("n1="+n1); //1.可以直接访问外部类的所有成员，包含私有的
                method();
            }
        }
        //5.外部类—访问—＞局部内部类的成员  访问方式：创建对象，再访问(注意：必须在作用域内)
        Inner01 inner01 = new Inner01();
        inner01.method02();
    }

}