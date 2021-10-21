package com.tommychan.learning.innerClass;

public class AnonymousExercise01 {
    public static void main(String[] args) {
        method_E01(new Inter_B() {   //将匿名内部类当做实参直接传递
            @Override                //简洁高效
            public void method_B01() {
                System.out.println("public void method_B01() is called");
            }
        });
    }

    public static void method_E01(Inter_B inter_b){
        inter_b.method_B01();
    }
}

interface Inter_B{
    public void method_B01();
}
