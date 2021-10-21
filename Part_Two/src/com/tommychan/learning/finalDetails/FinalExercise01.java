package com.tommychan.learning.finalDetails;

public class FinalExercise01 {
    public static void main(String[] args) {
        Round round = new Round(4);
        System.out.println("Round01: Radius:"+ round.getRadius()+" Square"+ round.getArea());
    }
}

//final修饰的属性在定义时，必须赋初值，并且以后不能再修改，赋值可以在如下位置之一
//(1)定义时
//(2)在构造器中
//(3)在代码块中

class Round{
    private double radius;
    private final double PI; //= 3.14

    public Round(double radius) {
        this.radius = radius;
        //PI = 3.14;
    }

    {
        PI = 3.14;
    }

    public double getArea(){
        return PI*radius*radius;
    }

    public double getRadius() {
        return radius;
    }
}