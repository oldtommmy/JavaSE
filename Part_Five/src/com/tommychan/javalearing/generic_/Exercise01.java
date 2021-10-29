package com.tommychan.javalearing.generic_;

import java.util.*;
/**
        1．创建 3个学生对象
        2．放入到 HashSet中学生对象，使用
        3．放入到 HashMap中，要求 Key 是 String name，Value 就是 学生对象
        4．使用两种方式遍历
*/
public class Exercise01 {
    public static void main(String[] args) {

        //1.存入HashSet中
        HashSet<Student> students = new HashSet<Student>();
        students.add(new Student("Tommy",19));
        students.add(new Student("Jack",17));
        students.add(new Student("Henry",24));

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (Student stu:students) {
            System.out.println(stu);
        }

        System.out.println("=========================");
        //2.存入HashMap
        HashMap<String, Student> students01 = new HashMap<>();
        students01.put("Tommy",new Student("Tommy",19));
        students01.put("Jack",new Student("Jack",17));
        students01.put("Henry",new Student("Henry",24));

        Set<Map.Entry<String,Student>> entrySet = students01.entrySet();
        for (Map.Entry entry:entrySet) {
            System.out.println(entry);
        }

    }
}

class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
