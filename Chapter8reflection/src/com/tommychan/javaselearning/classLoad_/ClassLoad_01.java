package com.tommychan.javaselearning.classLoad_;

public class ClassLoad_01 {
    public static void main(String[] args) {

        //分析如下：
        //1.加载B类 并生成B类的Class对象
        //2.连接阶段 num = 0;
        //3.初始化阶段
        //  按语句在源文件中出现的顺序
        //  依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句并进行合并
        /*
            clinit(){
                System.out.println("Code Blocks is called");
                num = 300;
                num = 100;//合并后 -> num = 100
            }
         */
        //System.out.println(new B().num);构造器也会被调用
        System.out.println(B.num);//构造器不调
        //输出：
        //Code Blocks is called
        //100
    }
}

class B{
    static {
        System.out.println("Code Blocks is called");
        num = 300;
    }

    static int num = 100;

    public B(){
        System.out.println("B constructor is called");
    }
}
