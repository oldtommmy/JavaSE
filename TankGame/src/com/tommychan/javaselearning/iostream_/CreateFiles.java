package com.tommychan.javaselearning.iostream_;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
  * @author TommyChan
  * @version 1.0
  * description:  演示用文件操作在 D 盘中新建文件
 */
@SuppressWarnings({"all"})
public class CreateFiles {

    public static void main(String[] args) {

    }

    //方法一 : file(String pathName)
    @Test
    public void createTxt01(){
        String path = "d:\\tempFiles\\test1.txt";
        File file = new File(path); //仅仅是在内存中创建了对象

        try {
            file.createNewFile(); //这一步才在硬盘里新建文件
            System.out.println("txt is successfully created!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方法二：file(File parentFile, String newFileName)
    @Test
    public void createTxT02(){
        File parentFile = new File("d:\\tempFiles");
        String newFileName = "test2.txt";
        File newFile = new File(parentFile,newFileName); //仅仅是在内存中创建了对象

        try {
            newFile.createNewFile();  //这一步才在硬盘里新建文件
            System.out.println("txt is successfully created!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方法三 ：file(String parentFile, String newFileName) 父目录 + 子路径
    @Test
    public void createTxT03(){
        String parentFile = "d:\\tempFiles";
        String newFileName = "test3.txt";

        File file = new File(parentFile, newFileName);
        try {
            file.createNewFile();
            System.out.println("txt is successfully created!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
