package com.tommylearning.exStuTea;

public class Teacher extends Person {
    private int work_age;

    public Teacher(String name, String sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public void teach(){
        System.out.println("我承认我会认真教学");
    }

    public String play(){
        return super.play()+"chess";
    }
}
