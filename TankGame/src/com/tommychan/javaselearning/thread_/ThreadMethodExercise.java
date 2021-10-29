package com.tommychan.javaselearning.thread_;

public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {

        Say say = new Say();
        Thread thread = new Thread(say);
        for (int i = 1; i <= 10; i++) {
            System.out.println("Hi "+ i);
            Thread.sleep(1000);
            if (i == 5){
                thread.start();
                thread.join();
            }
        }
    }
}
