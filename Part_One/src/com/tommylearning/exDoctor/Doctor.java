package com.tommylearning.exDoctor;

public class Doctor {
    private String name;
    private int age;
    private char gender;
    private double salary;

    public Doctor(String name, int age, char gender, double salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if(this instanceof Doctor){
            Doctor doctor = (Doctor) obj;
            if (this.age == doctor.age&&this.gender==doctor.gender&&this.name.equals(doctor.name)&&this.salary==doctor.salary){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
