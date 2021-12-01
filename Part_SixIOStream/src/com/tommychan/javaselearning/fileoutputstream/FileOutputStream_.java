package com.tommychan.javaselearning.fileoutputstream;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 演示 FileOutputStream
     * write(byte[] b) 将 b.length 个字节从指定字节数组写入此文件输出流
     */
    @Test
    public void writeFile() throws IOException {

        //创建FileOutputStream对象
        FileOutputStream fileOutputStream = null;
        String filePath = "d:\\tempFiles\\test2.txt";

        try {
            //1.new FileOutputStream（filePath）创建方式，当写入内容是，会覆盖原来的内容
            //2.new FileOutputStream（filePath， true）创建方式，当写入内容是，是追加到文件后面

            fileOutputStream = new FileOutputStream(filePath, true); //得到一个FileOutputStream对象

            //(1)写入一个字节
            fileOutputStream.write(':');

            //(2)写入一个字符串 write(byte[] b) 将 b.length 个字节从指定字节数组写入此文件输出流
            String s = "Hello World";
            fileOutputStream.write(s.getBytes()); //getBytes() 返回的是String的byte数组

            //(3) write(byte[] b, int off, int len) 将len字节从位于偏移量off的指定字节数组写入
            fileOutputStream.write(s.getBytes(),6,5);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}


