package com.tommychan.javaselearning.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

@SuppressWarnings({"all"})
public class Reflection01 {
    public static void main(String[] args) throws Exception{
        //先用Properties 类读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classPath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();

        //1.加载类 返回一个Class类型的对象 (Class 是一个类)
        Class cls = Class.forName(classPath);
        //2.通过 cls 去得到 com.tommychan.javaselearning.intropart.Cat 的对象实例
        Object o = cls.newInstance();
        //3.通过 cls 得到你加载的类的一个 methodName的方法对象
        //  即在反射中，可以把方法也视为对象，即万物届对象
        Method method = cls.getMethod(methodName);
        //4.通过method来调用方法
        //  即通过方法对象来调用方法
        method.invoke(o); //传统方法：对象.方法()
        //反射机制：方法对象.invoke(对象)

        //java.lang.reflect.Method：代表类的方法，Method对象表示某个类的方法
        //得到color字段
        /** getField不能拿到私有的属性 */
        Field field = cls.getField("color");
        System.out.println(field.get(o)); //输出 white
        //传统写法： 对象.属性
        //反射：成员变量对象.get(对象)

        //java.lang.reflect.Constructor：代表类的构造方法，Constructor对象表示构造器
        Constructor constructor = cls.getConstructor();//得到无参构造器
        System.out.println(constructor);

        Constructor constructor1 = cls.getConstructor(String.class);//得到有参构造器
        System.out.println(constructor1);
    }
}
