package com.tommychan.javaselearning.tankgame03;

public class Shot implements Runnable{

    private int x;
    private int y;
    private int direct;
    private int speed = 5;
    private boolean isLive = true;

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirect() {
        return direct;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isLive() {
        return isLive;
    }

    @Override
    public void run() {
        while (true){

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (direct){
                case 0: //up
                    y-=speed;
                    break;
                case 1: //right
                    x+=speed;
                    break;
                case 2: //down
                    y+=speed;
                    break;
                case 3: //left
                    x-=speed;
                    break;
            }

            //如果子弹飞到边界 或者由于击中了enemy 而使isLive被置为false 则退出进程
            if (!(x >= 0 && x <= 1400 && y >= 0 && y <= 1000)||!isLive) {
                System.out.println("子弹线程退出");
                isLive = false;
                break;
            }
        }
    }
}
