package com.tommychan.javaselearning.intropart;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author TommyChan
 * @version 1.0
 * description 反射快速入门
 */

@SuppressWarnings({"all"})
public class Solution {
    public static void main(String[] args) throws Exception {

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

    }
}
