package com.tommychan.javaselearning.class_;

import com.tommychan.javaselearning.Car;

import java.lang.reflect.Field;

/**
 * @author TommyChan
 * @version 1.0
 * description 演示 Class 类的常用方法
 */
@SuppressWarnings({"all"})
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        String classPath = "com.tommychan.javaselearning.Car";
        //1.获取到Car类对应的Class对象
        //<?>表示不确定的Java类型
        Class<?> cls = Class.forName(classPath);

        //2.输出cls
        System.out.println(cls); //显示cls是哪个类的Class对象 com.tommychan.javaselearning.Car
        System.out.println(cls.getClass());//输出cls的运行类型 class java.lang.Class

        //3.得到包名
        System.out.println(cls.getPackage()); //package com.tommychan.javaselearning

        //4.得到全类名
        System.out.println(cls.getName()); //com.tommychan.javaselearning.Car

        //5.通过cls创建一个对象实例
        Object o = cls.newInstance();
        Car car = (Car) o;
        System.out.println(car); //Car{brand='BWM', price=400000, color='Black'}

        //6.通过反射获取属性 -- 属性是存放在Field[] fields 里面的
        //  注意: getField不能拿到private的属性
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car)); //BWM

        //7.通过反射给属性赋值
        brand.set(car, "Benz");
        System.out.println(brand.get(car)); //Benz

        //8.得到所有的属性
        Field[] fields = cls.getFields();
        for(Field f:fields){ //遍历拿到所有属性的名称
            System.out.println(f.getName());
        }

    }
}
