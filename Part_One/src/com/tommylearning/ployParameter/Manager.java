package com.tommylearning.ployParameter;

public class Manager extends Employee{
    private int bonus;

    public Manager(String name, int salary, int bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public void manage(){
        System.out.println(getName()+" is a Manager");
    }

    @Override
    public int getAnnual() {
        return super.getAnnual()+bonus;
    }
}
