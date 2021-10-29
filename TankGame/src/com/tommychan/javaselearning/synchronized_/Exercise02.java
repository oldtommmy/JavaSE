package com.tommychan.javaselearning.synchronized_;

public class Exercise02 {
    public static void main(String[] args) {
        Account account = new Account();
        new Thread(account).start();
        new Thread(account).start();
    }
}

class Account implements Runnable{
    private double account = 1000;
    private boolean loop = true;

    @Override
    public void run() {
        while (loop){
            if (account<=0) {
                loop = false;
                return;
            }
            //1．这里使用 synchronized 实现了线程同步
            //2．当多个线程执行到这里时，就会去争夺 this对象锁
            //3．哪个线程争夺到（获取）this对象锁，就执行 synchronized 代码块
            //4．争夺不到this对象锁，就blocked，准备继续争夺
            //5. this对象锁是非公平锁
            synchronized (this){
                account-=100;
                System.out.println(Thread.currentThread().getName()+" take out 100 , balance:"+account);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
