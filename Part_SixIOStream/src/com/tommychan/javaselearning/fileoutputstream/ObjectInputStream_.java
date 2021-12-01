package com.tommychan.javaselearning.fileoutputstream;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
  * @author TommyChan
  * @version 1.0
  * description:进行反序列化
 */
public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String srcPath = "d:\\tempFiles\\Object01.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(srcPath));

        //需要根据序列化的顺序进行反序列化
        //否则会出错
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readUTF());


        Object o = ois.readObject();
        Dog dog = (Dog) o;
        System.out.println(dog);
        System.out.println("Dog name:"+dog.getName());
        //进行反序列化时 对于需要进行该操作的类的实例化对象
        //(1)如果想要调用该对象的方法，需要向下转型
        //(2)故也需要获取该类的定义 可将该类拷贝到可引用的位置
        //   就可以调用该对象的方法


        ois.close();
        System.out.println("读取结束");


    }
}

