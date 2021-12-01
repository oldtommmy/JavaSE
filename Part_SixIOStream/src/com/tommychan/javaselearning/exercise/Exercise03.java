package com.tommychan.javaselearning.exercise;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Exercise03 {
    public static void main(String[] args) throws IOException {
        //创建并加载指定配置文件
        Properties properties = new Properties();
        properties.load(new FileReader("src\\dog.properties"));

        Dog dog = new Dog(properties.getProperty("name"), Integer.valueOf(properties.getProperty("age")),
                            properties.getProperty("color"));
        System.out.println(dog.toString());
    }
}

class Dog{

    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}