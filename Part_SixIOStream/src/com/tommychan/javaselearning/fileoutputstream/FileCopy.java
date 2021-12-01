package com.tommychan.javaselearning.fileoutputstream;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {

        //完成文件的拷贝 ，将 d:\\tempFiles\\harrypotter.jpg 拷贝到 d:\\TommyChan\\Pic
        //思路：
        //1.创建文件的输入流 将文件读入程序
        //2.创建文件的输出流 将读取的文件数据 写入指定的文件
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        String srcFilePath = "d:\\tempFiles\\thumb.jpg";
        String destFilePath = "d:\\TommyChan\\Pics\\thumb.jpg";
        //一定要写完整 带上最终的文件名 而不能只是目录

        try {

            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath,true);

            int readLen = 0;
            byte[] b = new byte[1024];//定义一个byte数组 提高读取效率

            while ((readLen = fileInputStream.read(b))!=-1){
                fileOutputStream.write(b, 0, readLen);
                //这里不能用 write(byte[] b)
                //而要用write(byte[] b, int off, int len)
                //因为第一种方法每次将一个完整的byte数组写入 如果最后一次读入不够1024 但最后写入为1024
                //会使拷贝文件损坏
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
                System.out.println("copied successfully");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
