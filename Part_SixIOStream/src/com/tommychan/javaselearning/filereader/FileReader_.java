package com.tommychan.javaselearning.filereader;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {

    }

    /**
     * 用 read () 单个字符读取
     * read() 返回的是一个 int (读取的字符 ch 的 ASCII值)
     * 返回 -1 表示读取完毕
     */

    @Test
    public void readFile1(){
        FileReader fileReader = null; //创建一个FileReader对象
        String srcPath = "d:\\tempFiles\\test1.txt"; //文件路径

        try {
            fileReader = new FileReader(srcPath);
            int data = 0;

            while ((data = fileReader.read())!= -1){
                System.out.print((char)data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 用 read (char[] ch) 以字符串读取
     * read(char[] ch) 返回的是一个 int (读取的字符的个数)
     * 返回 -1 表示读取完毕
     */
    @Test
    public void readFile2(){
        FileReader fileReader = null; //创建一个FileReader对象
        String srcPath = "d:\\tempFiles\\test1.txt"; //文件路径

        try {
            fileReader = new FileReader(srcPath);
            int readLen = 0;
            char[] chars = new char[4];

            while ((readLen = fileReader.read(chars))!=-1) {
                System.out.println(new String(chars, 0, 4));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
