package com.tommychan.javaselearning.reflection;

import java.lang.reflect.Constructor;

/**
 * @author TommyChan
 * @version 1.0
 * description 演示使用反射创建对象
 */
public class ReflectCreateInstance {
    public static void main(String[] args) throws Exception{
        //1.先获取到User的Class对象
        Class<?> cls = Class.forName("com.tommychan.javaselearning.reflection.User");

        //2.通过 public 无参构造器
        Object o = cls.newInstance();
        System.out.println(o); //User{age=10, name='Tommy'}

        //3.通过 public 有参构造器
        //  这个constructor对象就是 public User(String name)构造器
        //(1)先得到构造器
        //(2)再创建实例，并传入形参
        Constructor<?> constructor = cls.getConstructor(String.class);
        Object o1 = constructor.newInstance("Henry");
        System.out.println(o1); //User{age=10, name='Henry'}

        //4.通过 private 有参构造器
        //(1)先得到构造器
        //(2)再创建实例，并传入形参
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(int.class, String.class);
        //由于declaredConstructor是private的 需要借助暴破
        declaredConstructor.setAccessible(true); //暴破：使用反射可以访问private构造器，方法，属性
        Object o2 = declaredConstructor.newInstance(18, "Charlie");
        System.out.println(o2);

    }
}

class User{

    private int age = 10;
    private String name = "Tommy";

    public User(){ // public 无参构造器

    }

    public User(String name) { //public 有参构造器
        this.name = name;
    }

    private User(int age, String name) { //private 有参构造器
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}