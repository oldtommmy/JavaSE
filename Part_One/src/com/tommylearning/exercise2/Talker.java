package com.tommylearning.exercise2;

public class Talker extends Teacher {
    private double rate = 1.1;
    public Talker(String name, int age, String post, double salary){
        super(name, age, post, salary);
    }

    public String introduce(){
        return super.introduce()+"\tSalary Rate："+rate;
    }
}
