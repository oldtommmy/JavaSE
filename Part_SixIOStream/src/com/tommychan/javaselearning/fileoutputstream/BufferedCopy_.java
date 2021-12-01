package com.tommychan.javaselearning.fileoutputstream;

import java.io.*;

/**
  * @author TommyChan
  * @version 1.0
  * description: 使用 BufferedOutputStream 和 BufferedInputStream
  *              完成对图片 , 音乐等二进制文件的拷贝
  *              实际上也是可以操作文本文件的
 */
public class BufferedCopy_ {
    public static void main(String[] args) {

        String srcPath = "d:\\tempFiles\\时间与落叶.mp3";
        String desPath = "d:\\tempFiles\\Files\\时间与落叶.mp3";

        BufferedOutputStream bufferedOutputStream = null;
        BufferedInputStream bufferedInputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(srcPath));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(desPath));

            byte[] bff = new byte[1024];
            int readLen = 0;
            //返回-1时 表示读取完毕
            while ((readLen = bufferedInputStream.read(bff))!= -1){
                bufferedOutputStream.write(bff,0, readLen);
            }
            System.out.println("Copy Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedInputStream.close();
                bufferedOutputStream.close();
                System.out.println("Over");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
