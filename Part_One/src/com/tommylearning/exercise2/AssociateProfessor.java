package com.tommylearning.exercise2;

public class AssociateProfessor extends Teacher {
    private double rate = 1.2;
    public AssociateProfessor(String name, int age, String post, double salary){
        super(name, age, post, salary);
    }

    public String introduce(){
        return super.introduce()+"\tSalary Rate："+rate;
    }
}
