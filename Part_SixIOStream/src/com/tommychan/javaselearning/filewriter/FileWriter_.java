package com.tommychan.javaselearning.filewriter;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {
    public static void main(String[] args) {

    }

    /**
     *   write(int) :写入单个字符
     *   write(String) : 写入整个字符串
     *   write(string, off, len)：写入字符串的指定部分
     *   write(char[])：写入指定数组
     *   write(char[], off, len)：写入指定数组的指定部分
     */
    @Test
    public void fileWrite(){

        String desPath = "d:\\tempFiles\\test3.txt";
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(desPath, true);
            fileWriter.write(':');
            fileWriter.write("hello fuck",6,4);
            fileWriter.write("the world");
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //fileWriter.flush(); -> 会调用 fileWriter.close()
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
