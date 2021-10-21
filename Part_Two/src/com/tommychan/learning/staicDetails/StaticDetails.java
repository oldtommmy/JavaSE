package com.tommychan.learning.staicDetails;

public class StaticDetails {
    public static void main(String[] args) {
        System.out.println(Student.count);

        Student student = new Student("Jack");
        System.out.println(Student.count+"  "+student.count);

        Student student1 = new Student("Mike");
        System.out.println(student.count+"  "+student1.count);

    }
}
