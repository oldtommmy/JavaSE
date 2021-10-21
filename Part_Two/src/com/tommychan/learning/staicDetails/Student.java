package com.tommychan.learning.staicDetails;

public class Student {
    private String name;
    public static int count = 0;

    public Student(String name) {
        this.name = name;
        count++;
    }
}
