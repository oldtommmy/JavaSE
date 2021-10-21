package com.tommylearning.ployArray;

public class Teacher extends Person {
    private int salary;
    private String course;

    public Teacher(String name, int age, int salary,String course) {
        super(name, age);
        this.salary = salary;
        this.course = course;
    }

    public String say(){
        return "Teacher "+super.say()+" Salary:"+salary;
    }

    public void showCourse(){
        System.out.println(" Teach:"+course);
    }
}
