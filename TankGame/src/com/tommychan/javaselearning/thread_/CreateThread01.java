package com.tommychan.javaselearning.thread_;
/**
 * @author TommyChan
 * @version 1.0
 * description: 通过继承 Thread 类实现创建线程
 *
*/
public class CreateThread01 {
    public static void main(String[] args) {

        Cat cat = new Cat();//创建Cat对象 作线程使用
        cat.start();//启动线程 源码中的start0 方法才是实现多线程的核心
        //当main线程启动一个子线程Thread-0 子线程不会阻塞main线程
        //可用j console检测

        //为什么不用cat.run(); 而是start 这样是从main线程中直接调用cat的某个方法 并不会启动新线程
        //这样只有将cat.run()执行完毕才会继续执行以下代码

        for (int i = 0; i < 80; i++) {
            System.out.println(i + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//1.当一个类继承了 Thread 类 ，则可以把该类当做线程使用
//2.重写 run 方法，来实现自己的业务代码
//3.Thread 类实现了 Runnable 接口的 run方法
class Cat extends Thread{
    @Override
    public void run() {
        int times = 0;
        //重写 run 方法，来实现自己的业务代码
        while (true){
            System.out.println("\"miao ~\": "+currentThread().getName());
            times++;
            try {
                Thread.sleep(1000); //线程休息 1s 此处只写Tread.sleep(1000) 会报错
            } catch (InterruptedException e) {//使用 try-catch 保证程序继续运行
                e.printStackTrace();
            }
            if (times == 80){
                break;
            }
        }
    }
}
