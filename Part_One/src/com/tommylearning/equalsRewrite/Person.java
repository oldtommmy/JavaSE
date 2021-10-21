package com.tommylearning.equalsRewrite;

public class Person {
    private String name;
    private char gender;
    private int age;

    public boolean equals(Object obj){
        if(this == obj){ //如果所比较的俩对象是同一对象 则直接返回true·
            return true;
        }
        if(this instanceof Object){
            Person p = (Person) obj; //向下转型 访问Person类特有属性
            if(this.age==p.age&&this.gender==p.gender&&this.name==p.name){
                return true;
            }
        }
        return false;
    }

    public Person(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
