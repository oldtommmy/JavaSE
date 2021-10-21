package com.tommylearning.exStuTea;

public class Student extends Person {
    private int stu_id;

    public Student(String name, String sex, int age, int stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public void study(){
        System.out.println("我承认我会好好学习");
    }

    public String play(){
        return super.play()+"football";
    }
}
