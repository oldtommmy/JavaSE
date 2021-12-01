package com.tommychan.javaselearning.fileoutputstream;

import java.io.*;

/**
  * @author TommyChan
  * @version 1.0
  * description:使用 ObjectOutputStream 进行序列化操作
 */
public class ObjectOutputStream_ {
    public static void main(String[] args) throws IOException {

        String srcPath = "d:\\tempFiles\\Object01.dat";

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(srcPath));

        objectOutputStream.writeInt(100); // int -> Integer
        objectOutputStream.writeBoolean(true); //boolean -> Boolean
        objectOutputStream.writeUTF("this is test");
        objectOutputStream.writeObject(new Dog("Henry",9));

        objectOutputStream.close();//关闭流
        System.out.println("Create Successfully");

    }
}

