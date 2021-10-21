package com.tommylearning.exercise2;

public class Professor extends Teacher{
    private double rate = 1.3;
    public Professor(String name, int age, String post, double salary){
        super(name, age, post, salary);
    }

    public String introduce(){
        return super.introduce()+"\tSalary Rate："+rate;
    }
}
