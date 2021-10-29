package com.tommychan.javaselearning.thread_;
/**
 * @author TommyChan
 * @version 1.0
 * description: 通过实现 Runnable 接口实现创建线程
 *
 */
public class CreatThread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Thread thread = new Thread(dog);
        thread.start();
        //使用了一种设计模式：[代理模式]
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        dog.setLoop(false);//进程结束
    }
}

class Dog implements Runnable{

    private int count = 0;
    private boolean loop = true; //控制进程结束
    @Override
    public void run() {
        while (loop){
            System.out.println("第"+(++count)+"只汪 "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {//控制进程结束
        this.loop = loop;
    }
}