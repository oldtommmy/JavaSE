package com.tommychan.javaselearning.getClassinfo;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author TommyChan
 * @version 1.0
 * description 如何通过反射获取类的结果信息
 */
@SuppressWarnings({"all"})
public class GetInfo01 {
    public static void main(String[] args) throws Exception{

    }

    @Test
    public void api_01() throws Exception{
        Class cls = Class.forName("com.tommychan.javaselearning.getClassinfo.Person");
        //getName：获取全类名
        System.out.println(cls.getName()); //com.tommychan.javaselearning.getClassinfo.GetInfo01.Person
        //getSimpleName：获取简单类名
        System.out.println(cls.getSimpleName()); //Person
        //getFields：获取所有public修饰的属性，包含本类以及父类的
        Field[] fields = cls.getFields();
        for(Field f:fields){
            System.out.println(f.getName());
        }
        //name
        //kind

        //getDeclaredFields：获取本类中所有属性
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        //name
        //age


        //getMethods：获取所有public修饰的方法，包含本类以及父类(不局限于直接父类)
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }


        //getDeclaredMethods：获取本类中所有方法
        Method[] declaredMethods = cls.getDeclaredMethods();

        //getConstructors：获取本类所有public修饰的构造器
        //getDeclaredConstructors：获取本类中所有构造器
        //getPackage：以Package形式返回 包信息
        //getSuperClass：以Class形式返回父类信息
        //getInterfaces：以Class［］形式返回接口信息
        Class[] interfaces = cls.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(interfaces);
        }
        //getAnnotations：以Annotation［］形式返回注解信息
    }
}

interface A{}

class Creature {
    public String kind;
}

class Person extends Creature implements A{
    public String name;
    protected int age;

}