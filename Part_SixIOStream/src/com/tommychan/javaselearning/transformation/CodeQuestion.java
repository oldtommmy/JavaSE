package com.tommychan.javaselearning.transformation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
  * @author TommyChan
  * @version 1.0
  * description: 读取某个含中文文本的文件到程序--演示乱码问题
 */
public class CodeQuestion {
    public static void main(String[] args) throws IOException {

        //创建字符处理流 并生成对象读取 txt 文件
        //文件读取的默认编码是 UTF-8
        //若不采用该编码 则会出现乱码
        String filePath = "d:\\tempFiles\\test1.txt";
        BufferedReader bf = new BufferedReader(new FileReader(filePath));

        String s = bf.readLine();
        System.out.println(s);
        bf.close();

    }
}
