package com.tommychan.javaselearning.synchronized_;

public class Locked {
    public static void main(String[] args) {
        new T(true).start();
        new T(false).start();
    }
}

class T extends Thread{

    static Object o1 = new Object();
    static Object o2 = new Object();
    boolean flag ;

    public T(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag){
            synchronized (o1){
                System.out.println(Thread.currentThread().getName()+" is into A");
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName()+" is into B");
                }
            }
        }else {
            synchronized (o2){
                System.out.println(Thread.currentThread().getName()+" is into C");
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName()+" is into D");
                }
            }
        }
    }
}
