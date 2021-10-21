package com.tommylearning.equalsRewrite;

public class RewriteTest {
    public static void main(String[] args) {
        Person person1=new Person("Jack",'男',18);
        Person person2=new Person("Jack",'男',18);
        Person person3=new Person("Cat",'男',15);

        System.out.println(person1.equals(person1));
        System.out.println(person1.equals(person2));
        System.out.println(person1.equals(person3));
    }
}
