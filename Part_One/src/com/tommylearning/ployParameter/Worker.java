package com.tommylearning.ployParameter;

public class Worker extends Employee{
    public Worker(String name, int salary) {
        super(name, salary);
    }

    public void work(){
        System.out.println(getName()+" is working");
    }

    public int getAnnual(){
        return super.getAnnual();
    }
}
