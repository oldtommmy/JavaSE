package com.tommylearning.ployParameter;

public class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getAnnual() {
        return salary*12;
    }

    public String getName() {
        return name;
    }
}
