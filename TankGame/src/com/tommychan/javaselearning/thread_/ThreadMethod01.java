package com.tommychan.javaselearning.thread_;

public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {

        int times = 0;
        Say say = new Say();
        Thread thread = new Thread(say);
        thread.start();
        while (true){
            System.out.println("Hi *"+(times++)+" from "+Thread.currentThread().getName());
            Thread.sleep(1000);
            if (times == 5){
                thread.join();
            }

            if (times == 20) break;
        }
    }
}

class Say implements Runnable{

    private boolean loop = true;
    private int count = 0;
    @Override
    public void run() {
        while (loop){
            System.out.println("Hello * "+(++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) loop = false;
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public boolean isLoop() {
        return loop;
    }

    public int getCount() {
        return count;
    }
}
