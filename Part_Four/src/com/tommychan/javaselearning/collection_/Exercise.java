package com.tommychan.javaselearning.collection_;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Exercise {
    public static void main(String[] args) {

        List dogs = new ArrayList();
        dogs.add(new Dog("ToTo","Black"));
        dogs.add(new Dog("Henry","White"));



        for(Object dog:dogs){
            System.out.println(dog);
        }

        Iterator iterator = dogs.iterator();
        while (iterator.hasNext()){
            Object dog = iterator.next();
            System.out.println(dog);
        }
    }
}

class Dog{
    private String name;
    private String color;

    public Dog(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
