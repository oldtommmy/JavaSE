package com.tommychan.javaselearning.synchronized_;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);

        a.start();
        b.start();
    }
}

class A extends Thread{

    private static boolean loop = true;
    private int count = 0;
    @Override
    public void run() {
        while (loop){
            System.out.println("RandomNum "+(++count)+"："+(int)(Math.random()*100+1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class B extends Thread{

    private A a;
    Scanner scanner = new Scanner(System.in);
    public B(A a){
        this.a = a;
    }

    @Override
    public void run() {
        while (true){
            char ch = scanner.next().toUpperCase().charAt(0);
            if (ch == 'q'|| ch == 'Q'){
                a.setLoop(false);
            }
            break;
        }
    }

}