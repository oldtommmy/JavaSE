package com.tommylearning.toStringLearning;

import java.lang.reflect.Array;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        Worker worker = new Worker("Jack","Cleaner");
        System.out.println(worker.toString());
        System.out.println(worker);
        int[] a = {1,2,3,3,4};
    }
}

class Worker{
    private String name;
    private String job;

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    public Worker(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
