package com.tommychan.javaselearning.iostream_;

import org.junit.jupiter.api.Test;

import java.io.File;

public class FileInformation {
    public static void main(String[] args) {

    }

    @Test
    public void info(){
        //先创建文件对象
        File file = new File("d:\\tempFiles\\test1.txt");

        //调用对应方法 获取相应信息
        //getName()
        System.out.println("File Name: "+ file.getName());

        //getAbsolutelyPath() 绝对路径
        System.out.println("Absolutely Path: "+ file.getAbsolutePath());

        //getParent() 父级目录
        System.out.println("File Parent : " + file.getParent());

        //length() 按字节来计算
        System.out.println("File Length : " + file.length());

        //是否存在
        System.out.println(file.exists());

        //是否是文件
        System.out.println(file.isFile());

        //是否是目录
        System.out.println(file.isDirectory());

    }
}

