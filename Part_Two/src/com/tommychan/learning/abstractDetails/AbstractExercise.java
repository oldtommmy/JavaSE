package com.tommychan.learning.abstractDetails;

public class AbstractExercise {
    public static void main(String[] args) {
        Manager manager = new Manager("Jack", 29, 9000, 3000);
        CommonEmployee commonEmployee = new CommonEmployee("Merry", 21, 6500);

        System.out.println(manager.work());
        System.out.println(commonEmployee.work());

    }
}

abstract class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public abstract String work();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee{

    private double bonus;
    public Manager(String name, int age, double salary,double bonus){
        super(name, age, salary);
        this.bonus = bonus;
    }

    public String work(){
        return "Type: Manager\tName: "+getName()+"\tAge:"+getAge()+"\tSalary:"+(getSalary()+bonus);
    }
}

class CommonEmployee extends Employee{
    public CommonEmployee(String name, int age, double salary){
        super(name, age, salary);
    }

    public String work(){
        return "Type: CommonEmployee\tName: "+getName()+"\tAge:"+getAge()+"\tSalary:"+getSalary();
    }
}
