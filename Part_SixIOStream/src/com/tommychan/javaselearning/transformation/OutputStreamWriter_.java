package com.tommychan.javaselearning.transformation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
  * @author TommyChan
  * @version 1.0
  * description: 使用 OutputStreamWriter
  *              将 FileInputStream (字节流)转换为 OutputStreamWriter(字符流)
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {

        String filePath = "d:\\tempFiles\\test1.txt";

        //创建OutputStreamWriter 并指定写入的编码 utf-8
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath),"utf8");
        osw.write("这是一个按gbk编码的测试程序写入的中文文本");

        //关闭流
        osw.close();
    }
}
