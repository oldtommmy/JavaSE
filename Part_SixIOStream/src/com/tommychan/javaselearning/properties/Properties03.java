package com.tommychan.javaselearning.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author TommyChan
 * @version 1.0
 * description 使用 Properties 添加 key-val 到新文件zhong
 *             使用 Properties 修改配置文件内容
 */
public class Properties03 {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        //创建
        //如果该文件没有key则是创建
        //否则则是修改
        //Properties 父类是 HashTable

        properties.setProperty("charset", "utf8");
        properties.setProperty("user", "汤米"); //保存的是“汤米”的Unicode
        properties.setProperty("pwd","12345");
        properties.setProperty("pwd","43242");//修改了密码
        //将k-v储存到新文件
        properties.store(new FileOutputStream("src\\mysql2.properties"),"this is a test");

    }
}
