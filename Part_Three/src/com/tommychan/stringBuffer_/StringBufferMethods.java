package com.tommychan.stringBuffer_;

public class StringBufferMethods {
    public static void main(String[] args) {
        //1. append 增
        StringBuffer hello = new StringBuffer("Hello");
        hello.append(" World");
        System.out.println(hello);
        hello.append(" I am").append(" Tommy");
        System.out.println(hello); //hello = "Hello World I am Tommy"

        //2. delete 删除索引为 >=from <to 的处的字符 即 [from,to)
        hello.delete(0,12);
        System.out.println(hello);//hello = "I am Tommy"

        //3. replace 替换索引为 [from,to)的字符
        hello.replace(2,4,"was");
        System.out.println(hello);//hello = "I was Tommy"

        //4. indexOf 查找字串在字符串第一次出现的位置 若没有返回-1
        int indexOf = hello.indexOf("was");
        System.out.println("'was' index =  "+indexOf); //'was' index =  2

        //5. insert 插入 insert(index,"sss") index处及之后的内容自动后移
        hello.insert(5," cool");
        System.out.println(hello); //hello = I was cool Tommy

        //6. length 长度  length()方法可以得到当前StringBuffer的长度。
        System.out.println("length = " + hello.length());//length = 16

        //7.capacity 空间 而通过调用capacity()方法可以得到总的分配
        System.out.println("capacity = "+hello.capacity());//capacity = 44
    }
}
