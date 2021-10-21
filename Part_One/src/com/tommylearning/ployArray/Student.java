package com.tommylearning.ployArray;

public class Student extends Person {
    private double score;
    private String grade;

    public Student(String name, int age, double score,String grade) {
        super(name, age);
        this.score = score;
        this.grade = grade;
    }

    public String say(){
        return "Student "+super.say()+" Score:"+score;
    }

    public void showGrade() {
        System.out.println(" Grade:" + grade);
    }
}
