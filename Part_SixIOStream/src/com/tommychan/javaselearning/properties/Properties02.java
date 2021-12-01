package com.tommychan.javaselearning.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author TommyChan
 * @version 1.0
 * description 使用 Properties 类来读取 mysql.properties文件的数据
 */
public class Properties02 {
    public static void main(String[] args) throws IOException {

        //1.创建Properties对象
        Properties properties = new Properties();
        //2.加载指定配置文件
        properties.load(new FileReader("src\\mysql.properties"));
        //3.把键值对显示到控制台
        properties.list(System.out);
        //4.根据 key 来获取相应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        String id = properties.getProperty("id");

        System.out.println("user:"+user +" pwd:"+pwd +" id:"+id);
    }
}
