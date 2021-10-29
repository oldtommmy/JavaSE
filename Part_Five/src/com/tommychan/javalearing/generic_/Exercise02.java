package com.tommychan.javalearing.generic_;

import java.util.ArrayList;
import java.util.Comparator;

public class Exercise02 {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("tom",25000,new MyDate(2002,4,26)));
        employees.add(new Employee("henry",18000,new MyDate(2001,5,21)));
        employees.add(new Employee("ann",35000,new MyDate(1998,4,26)));
        employees.add(new Employee("ann",25000,new MyDate(1998,4,25)));

        System.out.println(employees);
        System.out.println("================================");
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int i = o1.getName().compareTo(o2.getName());
                if (i != 0) {
                    return i;
                }

                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });

        System.out.println(employees);
    }
}

class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int compareTo(MyDate o1) {

        int yearMinus = this.getYear() - o1.getYear();
        if (yearMinus != 0) {
            return yearMinus;
        }

        int monthMinus = this.getMonth() - o1.getMonth();
        if (monthMinus != 0) {
            return monthMinus;
        }

        int dayMinus = this.getDay() - o1.getDay();
        if (dayMinus != 0) {
            return dayMinus;
        }
        return 0;
    }
}

class Employee{
    private String name;
    private double salary;
    private MyDate birthday;

    public Employee(String name, double salary, MyDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}'+"\n";
    }
}


