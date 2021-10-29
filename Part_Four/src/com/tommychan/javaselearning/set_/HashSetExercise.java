package com.tommychan.javaselearning.set_;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExercise {
    public static void main(String[] args) {
        Employee tommy = new Employee(2002, 2, 1, "Tommy", 19000);
        Employee sam = new Employee(2003, 2, 1, "Sam", 21000);
        Employee tommy1 = new Employee(2002, 2, 1, "Tommy", 22000);

        HashSet hashSet = new HashSet();
        hashSet.add(tommy);
        hashSet.add(tommy1);
        hashSet.add(sam);

        System.out.println(hashSet);
    }
}

class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year &&
                month == myDate.month &&
                day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}

class Employee extends MyDate{
    private String name;
    private double salary;

    public Employee(int year, int month, int day, String name, double salary) {
        super(year, month, day);
        this.name = name;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}


