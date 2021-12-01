# JavaChapter6 IO流

# IO流

## （1）文件的相关概念

文件：简单来说，文件就是 **保存数据** 的地方。

**文件流** ：

- 文件是以流的形式来操作的

- 流：数据在数据源（文件）和程序（内存）之间经历的路径

- 输入流：数据从数据源（文件）到程序（内存）的路径

- 输出流：数据从程序（内存）到数据源（文件）的路径

![](https://gitee.com/tommychanchan/markdown-pics/raw/master/img/imageio1.png)

## （2）常见文件操作

**创建文件** ：

- `File(String pathname)` 通过将给定的路径名字符串转换为抽象路径名来创建新的`File`实例

- `File(File parent, String child)` 从父抽象路径名和子路径名字符串创建新的`File`实例

- `File(String parent, String child)`从父路径名字符串和子路径名字符串创建新的`File`实例


```Java
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
```

### 获取文件信息：

- `getName()` 获取文件名

- `getAbsolutelyPath()` 获取绝对路径

- `getParent()` 获取父目录

- `length()` 获取长度—按字节统计

- `exists()` 是否存在

- `isFile()` 是否是文件

- `isDirectory()` 是否是目录

  更多方法参考api ... ...


## （3）目录操作

- 创建一级目录用`mkdir()`

- 创建多级目录用`mkdirs()`

```Java
public void m1(){

        String pathName = "d:\\tempFiles\\txtFiles";
        File file = new File(pathName);

        String pathName02 = "d:\\txtFiles";
        File file1 = new File(pathName02);

        if (file.exists()){
            System.out.println("Directory existed");
        }else{
            file.mkdirs();//创建多级目录用 mkdirs()
            System.out.println("Can't find this Directory ... Created successfully");
        }

        if (file1.exists()){
            System.out.println("Directory existed");
        }else{
            file1.mkdir();//创建一级目录用 mkdir()
            System.out.println("Can't find this Directory ... Created successfully");
        }
    }

```



## （4）IO流原理和分类

  **Java IO流原理** 

1. I/O是Input/Output的缩写，I/O技术是非常实用的技术，用于处理数据传输如读/写文件，网络通讯等。

2. Java程序中，对于数据的输入/输出操作以“ 流（stream）”的方式进行。

3. java.io包下提供了各种“流”类和接口，用以获取不同种类的数据，并通过方法输入或输出数据。

4. 输入input：读取外部数据（磁盘、光盘等存储设备的数据）到程序（内存）中。

5. 输出output：将程序（内存）数据输出到磁盘、光盘等存储设备或是网络、数据库中。


**流的分类** 

- 按操作数据单位不同分为：字节流（8 bit）（通常用于二进制文件），字符流（按字符）（常用于文本文件）

- 按数据流的流向不同分为：输入流，输出流

- 按流的角色的不同分为：节点流，处理流／包装流

**小结：**

- Java的IO流共涉及40多个类，实际上非常规则，都是从如上4个抽象基类派生的。

- 由这四个类派生出来的子类名称都是以其父类名作为子类名后缀。

|抽象基类|                  字节流|字符流|
|---|---|---|
|输入流|InputStream|Reader|
|输出流|OutputStream|Writer|




## （5）InputStream 字节输入流

```Java
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



```


## （6）OutputStream 字节输出流

```Java
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



```



**实例：完成文件的拷贝** —图片的拷贝


![](https://gitee.com/tommychanchan/markdown-pics/raw/master/img/image_io2.png)

```Java
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

```



## （7）FileReader 字符输入流

**FileReader相关方法：** 

- `new FileReader(File/String)`

- `read()`：每次读取单个**字符** ，返回该字符，如果到文件未属返回 -1

- `read(char[])`：批量读取**多个字符** 到数组，返回读取到的字符数，如果到文件未尾返回 -1

**相关API：** 

- `new String(char[] ch) `: 将ch转换成String

- `new String(char[] ch，int off，int len)`：将ch的指定部分转换成String

```Java
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
```



## （8）FileWriter 字符输出流

**FileWriter常用方法** 

-  `new FileWriter(File/String)`: 覆盖模式，相当于流的指针在首端

-  `new FileWriter(File/String，true)`：追加模式，相当于流的指针在尾端

-  `write(int)` :写入单个字符

-  `write(char[])`：写入指定数组

-  `write(char[],off,len)`：写入指定数组的指定部分

-  `write (string)` ：写入整个字符串

-  `write(string, off, len)`：写入字符串的指定部分

相关API： String类： `toCharArray`：将String转换成char[]

注意:  FileWriter使用后，**必须要关闭（close）或刷新（flush），否则写入不到指定的文件！** 

```Java
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
```



## （9）节点流与处理流

### **基本介绍：** 

- 节点流可以从一个特定的数据源读写数据，如FileReader、FileWriter

- 处理流（也叫包装流）是“连接”在已存在的流（节点流或处理流）之上，为程序提供更为强大的读写功能，如BufferedReader、BufferedWriter

- 节点流与处理流一览表

![](https://gitee.com/tommychanchan/markdown-pics/raw/master/img/image_io3.png)


![](https://gitee.com/tommychanchan/markdown-pics/raw/master/img/image_io4.png)

### 节点流和处理流的区别和联系

**区别：** 

1. 节点流是底层流／低级流，直接跟数据源相接。

2. 处理流（**包装流** ）包装节点流，既可以消除不同节点流的实现差异，也可以提供更方便的方法来完成输入输出。

3. 处理流（也叫包装流）对节点流进行包装，使用了修饰器设计模式，不会直接与数据源相连［**模拟修饰器设计模式** ］


```Java
public abstract class Reader_ { //抽象类
    public void readFile() {
    }
    public void readString() {
    }

    //在Reader_ 抽象类，使用read方法统一管理.
    //后面在调用时，利于对象动态绑定机制， 绑定到对应的实现子类即可.
    //public abstract void read();
}
```



```Java
public class FileReader_ extends Reader_ {
        public void readFile() {
        System.out.println("对文件进行读取...");
    }
}

```



```Java
public class StringReader_ extends Reader_ {
    public void readString() {
        System.out.println("读取字符串..");
    }
}
```



```Java
/** 
 * 做成处理流/包装流
 */
public class BufferedReader_ extends Reader_{

    private Reader_ reader_; //属性是 Reader_类型

    //接收Reader_ 子类对象
    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }

    public void readFile() { //封装一层
        reader_.readFile();
    }

    //让方法更加灵活， 多次读取文件, 或者加缓冲byte[] ....
    public void readFiles(int num) {
        for(int i = 0; i < num; i++) {
            reader_.readFile();
        }
    }

    //扩展 readString, 批量处理字符串数据
    public void readStrings(int num) {
        for(int i = 0; i <num; i++) {
            reader_.readString();
        }
    }

}
```



```Java
public class Test_ {
    public static void main(String[] args) {


        BufferedReader_ bufferedReader_ = new BufferedReader_(new FileReader_());
        bufferedReader_.readFiles(10);
        //bufferedReader_.readFile();
        //Serializable
        //Externalizable
        //ObjectInputStream
        //ObjectOutputStream
        //这次希望通过 BufferedReader_ 多次读取字符串
        BufferedReader_ bufferedReader_2 = new BufferedReader_(new StringReader_());
        bufferedReader_2.readStrings(5);
    }
}
```



**处理流的功能** 

主要体现在以下两个方面：

1. 性能的提高：主要以增加缓冲的方式来提高输入输出的效率。

2. 操作的便捷：处理流可能提供了一系列便捷的方法来一次输入输出大批量的数据，使用更加灵活方便

## （10）BufferedReader 与 BufferedWritter

- BufferedReader 和 BufferedWriter 属于字符流，是按照字符来读取数据的

- 关闭时处理流，只需要关闭外层流即可［后面看源码］

```Java
package com.tommychan.javaselearning.filewriter;

import java.io.*;
/**
  * @author TommyChan
  * @version 1.0
  * description: 演示用包装流进行文件拷贝
  * BufferedReader 与 BufferedWriter 是按照字符操作
  * 不要去操作二进制文件 (声音 视频 等) 
 */ 
public class BufferedCopy_ {
    public static void main(String[] args) throws IOException {

        String srcPath = "d:\\tempFiles\\test1.txt";
        String desPath = "d:\\tempFiles\\test2.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(srcPath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(desPath));

        String line;
        //边读取边写入
        try {
            while ((line = bufferedReader.readLine())!=null){
                bufferedWriter.write(line);
                bufferedWriter.newLine();//写入一个换行
            }
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
                System.out.println("流已关闭");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
```



## （11）BufferedlnputStream与BufferedOutputStream

- BufferedlnputStream是字节流，在创建BufferedlnputStream时，会创建一个内部缓冲区数组

- BufferedOutputStream是字节流，实现缓冲的输出流，可以将多个字节写入底层输出流中，而不必对每次字节写入调用底层系统

```Java
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
```




## （12）对象流 ObjectInputStream  ObjectOutputStream

看一个**需求** ：

1. 将int num = 100这个int数据保存到文件中，注意不是100数字，而是`int 100`，并且，能够从文件中直接恢复`int 100`

2. 将`Dog dog = new Dog( "小黄" , 3)` 这个dog对象保存到文件中，并且能够从文件恢复

上面的要求，就是能够将基本数据类型或者对象进行序列化和反序列化操作


**序列化和反序列化** 

- 序列化就是在保存数据时，保存数据的值和数据类型

- 反序列化就是在恢复数据时，恢复数据的值和数据类型

- 需要让某个对象支持序列化机制，则必须让其类是可序列化的，为了让某个类是可序列化的，该类必须实现如下两个接口之一：

`Serializable `：这是一个标记接口 没有方法

`Externalizable `：该接口有方法需要实现 *因此我们一般实现上面的接口* 


**案例** ：

```java
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

    //要进行序列化 需要实现Serializable接口
    static class Dog implements Serializable {
        private String name;
        private int age;

        public Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}


```


反序列化：

```Java
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
```


**序列化注意事项和细节说明** 

- 读写顺序要一致<br />

- 要求序列化或反序列化对象，需要实现`Serializable`

- 序列化的类中建议添加`SerialVersionUID`，为了提高版本的兼容性

- 序列化对象时，默认将里面所有属性都进行序列化，但除了`static`或`transient`修饰的成员

- 序列化对象时，要求里面属性的类型也需要实现序列化接口，比如本类中有另一个类的对象，则该类也需要实现序列化接口

- 序列化具备可继承性，也就是如果某类已经实现了序列化，则它的所有子类也已经默认实现了序列化

## （13）标准输入输出流

| |编译类型|运行类型|默认设备|
|---|---|---|---|
|System.in标准输入|InputStream|BufferedInputStream|键盘|
|System.out 标准输出|PrintStream|PrintStream|显示器|



## （14）转换流 InputStreamReader 和 OutputStreamWriter 

**看一个文件乱码问题：** 

在用字符处理流BufferedReader 读取某个含有中文文本的txt时，默认读取编码是UTF-8，如果改为其他编码格式，则会出现乱码情况，因此我们引入转化流。


**基本介绍：** 

1．`InputStreamReader`：`Reader`的子类，可以将`InputStream`（字节流）包装成`Reader`（字符流）<br />2．`OutputStreamWriter`：`Writer`的子类，实现将`OutputStream`（字节流） 包装成`Writer`（字符流）<br />3．当处理纯文本数据时，如果使用字符流效率更高，并且可以有效解决中文问题，所以建议将字节流转换成字符流<br />4． 可以在使用时指定编码格式（比如 UTF—8，gbk，gb2312，ISO8859—1等）


`InputStreamReader`

```Java
package com.tommychan.javaselearning.transformation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
  * @author TommyChan
  * @version 1.0
  * description: 使用 InputStreamReader 将字节流转换为字符流
 */ 
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {

        String filePath = "d:\\tempFiles\\test1.txt";
        //用InputStreamReader将字节流转换为字符流 并指定读取的编码格式
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath),"gbk");

        BufferedReader br = new BufferedReader(isr);
        //读取
        String s = br.readLine();
        System.out.println(s);

        //关闭外层流
        br.close();
        
    }
}
```



`FileOutputStream`

```Java
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

        //创建OutputStreamWriter 并指定写入的编码 gbk
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath),"gbk");
        osw.write("这是一个按gbk编码的测试程序写入的中文文本");

        //关闭流
        osw.close();
    }
}
```



## （15）打印流PrintStream和PrintWriter

&ensp;&ensp;&ensp;&ensp;                                                                 ——只有输出流没有输入流

```Java
/**
  * @author TommyChan
  * @version 1.0
  * description: 演示 PrintStream (字节打印流)
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {

        PrintStream out = System.out;
        out.println("hello world"); //默认输出位置是 标准输出 即在显示器输出
                            //底层调用的是 write()方法
        out.write("hello world".getBytes()); //故也可以直接调用write()方法
        out.close();

        //也可以修改打印流输出的位置，设备
        System.setOut(new PrintStream("d:\\tempFiles\\test1.txt"));
        System.out.println("hello world");//输入，写入到d:\\tempFiles\\test1.txt
    }
}
```


```Java
/*
 * @author TommyChan
 * @version 1.0
 * description 演示 PrintWriter 的使用
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {

        PrintWriter printWriter = new PrintWriter(System.out);//传入的是标准输出 在屏幕，显示器输出
        printWriter.println("hello world");
        printWriter.close();

        PrintWriter printWriter1 = new PrintWriter(new FileWriter("d:\\tempFiles\\test1.txt"));
        printWriter1.println("hello world!!!");//输出到"d:\\tempFiles\\test1.txt"
        printWriter1.close();//一定要关闭 否则无法写入
    }
}
```



# Properties类

## （1）需求分析

> 如下一个配置文件 mysql.properties     ip = 192.168.0.13   user = root   pwd = 12345     


如何通过程序来读取信息？


```Java
/*
 * @author TommyChan
 * @version 1.0
 * description 传统方法读取
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line = "";
        while ((line = bfr.readLine())!=null){
            String[] spilt = line.split("=");
            System.out.println(spilt[0]+"的值是"+spilt[1]);
        }
        bfr.close();
    }
}
// spilt 分割字符串：
```



## （2）基本介绍

Properties类是专门用于读写配置文件的集合类
配置文件的格式： 

     键＝值
     键＝值

注意：键值对**不需要有空格** ，值**不需要用引号** 括起来，默认类型是String


## （3）**Properties的常见方法** 

`load`：加载配置文件的键值对到Properties对象

`list`：将数据显示到指定设备

`getProperty(key)`:根据健获取值

`setProperty（key，value）`：设置健值对到Properties对象

`store`：将Properties中的健值对存储到配置文件，在idea中，保存信息到配置文件，如果含有中文，会存储为unicode码


**读取文件：** 

```Java
/**
 * @author TommyChan
 * @version 1.0
 * description 使用 Properties 类来读取 mysql.properties文件的数据
 */
public class Properties02 {
    public static void main(String[] args) throws IOException {

        //1.创建Properties对象
        Properties properties = new Properties();
        //2.加载指定配置文件
        properties.load(new FileReader("src\\mysql.properties"));
        //3.把键值对显示到控制台
        properties.list(System.out);
        //4.根据 key 来获取相应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        String id = properties.getProperty("id");

        System.out.println("user:"+user +" pwd:"+pwd +" id:"+id);
    }
}
```


**写入数据：** 

```Java
//使用 Properties 添加 key-val 到新文件中
//使用 Properties 修改配置文件内容
 
public class Properties03 {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        //创建
        //如果该文件没有key则是创建
        //否则则是修改
        //Properties 父类是 HashTable
        
        properties.setProperty("charset", "utf8");
        properties.setProperty("user", "汤米"); //保存的是“汤米”的Unicode
        properties.setProperty("pwd","12345");
        properties.setProperty("pwd","43242");//修改了密码
        //将k-v储存到新文件
        properties.store(new FileOutputStream("src\\mysql2.properties"),"this is a test");

    }
}
```

