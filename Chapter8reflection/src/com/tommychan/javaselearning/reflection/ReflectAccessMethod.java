package com.tommychan.javaselearning.reflection;

import java.lang.reflect.Method;

/**
 * @author TommyChan
 * @version 1.0
 * description 演示反射调用方法
 */
public class ReflectAccessMethod {
    public static void main(String[] args) throws Exception{

        Class<?> cls = Class.forName("com.tommychan.javaselearning.reflection.Boss");

        //1. 根据方法名和参数列表获取Method方法对象:                                                                 `Method m = cls.getDeclaredMethod(方法名, XX.class);`
        Method hi = cls.getMethod("hi",String.class);
        //也可以使用Method hi = cls.getDeclaredMethod("hi",String.class);
        //得到private static的方法 只能用getDeclaredMethod
        Method say = cls.getDeclaredMethod("say", int.class, String.class, char.class);

        //2. 获取对象: Object o = cls.newInstance();
        Object o = cls.newInstance();
        //2.1 调用普通方法 hi(String s)
        hi.invoke(o,"Tommy");
        //2.2 想要调用非public的方法 say 需要暴破

        //3. 暴破: m.setAccessible(true);
        //   才可操作非public的方法
        say.setAccessible(true);
        System.out.println(say.invoke(o,19,"Tommy",'1'));
        //注意：如果是静态方法，则invoke的第一个参数o，可以写成null

        //4.在反射中，如果有方法返回值，统一返回Object类，但是运行类型与方法的返回类型一致
        //  Object returnValue = m.invoke(o，实参列表);
        Object sayReturn = say.invoke(o, 19, "Jack", '1');
        System.out.println(sayReturn.getClass());
    }
}

class Boss{

    public int age;
    private String name;

    public Boss() { }

    private static String say(int n, String s, char c){
        return n+" "+s+" "+c;
    }

    public void hi(String s){
        System.out.println("hi "+s);
    }
}