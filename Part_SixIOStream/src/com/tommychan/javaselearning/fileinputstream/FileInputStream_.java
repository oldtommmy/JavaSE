package com.tommychan.javaselearning.fileinputstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
  * @author TommyChan
  * @version 1.0
  * description: 演示 FileInputStream 的使用 (字节输入流 文件 --> 程序 )
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    /**
      * 单个字节读取 效率较低
     */
    @Test
    public void reaFile01(){

        String filePath = "d:\\tempFiles\\test1.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;    //创建FileInputStream对象 用于读取文件
        try {
            fileInputStream = new FileInputStream(filePath);
            //从该输入流中读取  一个字节  的数据 如果没有数据可读取 此方法将阻止
            //由于不同编码格式中 汉字所占字节不一 故采用单个字节读取可能会出现乱码
            //所以我们通常不用FileInputStream读取文本文件
            //如果返回 -1 代表读取完毕
            while ((readData = fileInputStream.read())!=-1){
                System.out.print((char)readData); //转成char显示
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 使用 read (byte[] b) 读取文件 效率较高
     */
    @Test
    public void readFile02(){
        String filePath = "d:\\tempFiles\\test1.txt";
        int readLen = 0; //接收read(byte[] b)返回的数
        byte[] buf = new byte[4]; //新建byte数组 用于控制每次读取的字节长度
        FileInputStream fileInputStream = null;    //创建FileInputStream对象 用于读取文件
        try {
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取最多b.length字节的数据到字节数组 ，此方法用于阻塞 ，直到某些输入可用
            //如果读取正常 返回实际读取的字节数
            //如果返回 -1 则表示读取正常
            while ((readLen = fileInputStream.read(buf))!=-1){
                System.out.print(new String(buf, 0, readLen)); //转成char显示
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


