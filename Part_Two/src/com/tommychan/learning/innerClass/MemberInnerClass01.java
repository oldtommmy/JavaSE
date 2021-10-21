package com.tommychan.learning.innerClass;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method4_1();
    }
}

class Outer04{ //外部类
    private int n3 = 10;

    public class Inner_C{ //(1)成员内部类 定义在外部类的成员位置上
        private int n3 = 20;
        public void method_C(){  //(2)可以访问外部类的所有成员 包括私有
            System.out.println("n3="+n3); //(3)可以任意添加访问修饰符 因为其属于成员
            System.out.println("Outer n3 = "+Outer04.this.n3);
        }
    }
    //外部类———访问————＞内部类（说明）访问方式：创建对象，再访问
    public void method4_1(){
        Inner_C inner_c = new Inner_C();
        inner_c.method_C();
    }
    
    public Inner_C getInner_C(){
        return new Inner_C();
    }
}

//外部其他类——访问———＞成员内部类
class Outer05{
    public void method5_1(){
        //第一种方式
        Outer04 outer04 = new Outer04();
        Outer04.Inner_C inner_c = outer04.new Inner_C();
        inner_c.method_C();
        //第二种方式 在外部类中写一个方法返回类
        Outer04.Inner_C inner_c1 = outer04.getInner_C();
        inner_c1.method_C();

    }
}