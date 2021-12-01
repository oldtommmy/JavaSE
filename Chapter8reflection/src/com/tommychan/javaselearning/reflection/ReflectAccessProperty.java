package com.tommychan.javaselearning.reflection;

import java.lang.reflect.Field;

public class ReflectAccessProperty {
    public static void main(String[] args) throws Exception{

        //1.得到Student的Class对象
        Class<?> cls = Class.forName("com.tommychan.javaselearning.reflection.Student");

        //2.创建一个Student对象
        Object o = cls.newInstance();

        //3.使用反射得到 age 属性
        Field age = cls.getField("age");
        age.set(o, 18); //通过反射来操作属性
        System.out.println(age.get(o)); //输出age的值

        //4.使用反射操作 name 属性 (private static)
        Field name = cls.getDeclaredField("name");
        //先爆破 再操作
        name.setAccessible(true);
        name.set(o,"Tommy");
        //name.set(null,"Tommy"); o也可以写成null 因为name是static的属性
        System.out.println(name.get(o));
        //或 System.out.println(name.get(null));
        System.out.println(o);
    }
}

class Student{
    public int age = 0;
    private static String name;

    public Student() {}

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ",name=" + name +
                '}';
    }
}