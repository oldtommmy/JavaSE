package com.tommychan.javaselearning.class_;

import com.tommychan.javaselearning.Car;

/**
 * @author TommyChan
 * @version 1.0
 * description 演示得到 Class 对象的六种方法
 */
@SuppressWarnings({"all"})
public class GetClass_ {
    public static void main(String[] args) throws Exception{

        //1.通过forName()获得
        Class cls1 = Class.forName("com.tommychan.javaselearning.Car");
        System.out.println(cls1);

        //2.通过类名.class     应用场景：通常用于参数传递
        Class cls2 = Car.class;
        System.out.println(cls2);

        //3.通过对象名.getClass() 应用场景：有对象实例了
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println(cls3);

        //4.通过类加载器获得
        //(1)先得到类加载器
        ClassLoader classLoader = car.getClass().getClassLoader();
        //(2)通过类加载器得到Class对象
        Class<?> cls4 = classLoader.loadClass("com.tommychan.javaselearning.Car");
        System.out.println(cls4);

        //cls1 cls2 cls3 cls4 其实是同一个对象 因为对于一个类而言 堆中只有一个它的Class对象

        //5.基本数据类型也可以得到Class类对象
        // Class cls = 基本数据类型.class
        Class<Integer> integerClass = int.class;
        System.out.println(integerClass); //int
        System.out.println(integerClass.hashCode()); //与下面type.hashCode()的相同

        //6.基本数据类型对应的包装类 可以通过.TYPE得到Class对象
        Class<Integer> type = Integer.TYPE;
        System.out.println(type); //int
        System.out.println(type.hashCode());

    }
}
