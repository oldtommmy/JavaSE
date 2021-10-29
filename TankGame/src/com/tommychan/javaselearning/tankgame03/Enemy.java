package com.tommychan.javaselearning.tankgame03;

import java.util.Vector;

public class Enemy extends Tank implements Runnable {
    //用Vector保存多个Shot
    private Vector<Shot> shots = new Vector<>();
    private boolean isLive = true;


    public void setLive(boolean live) {
        isLive = live;
    }

    public boolean isLive() {
        return isLive;
    }

    public Enemy(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }


    public Vector<Shot> getShots() {
        return shots;
    }

    @Override
    public void run() {
        while (true){

            if (isLive && shots.size()<=2){//如果坦克存活且子弹小于2发
                Shot shot = null;          //则按照方向新加子弹
                switch (getDirect()){
                    case 0: //up
                        shot = new Shot(getX()+20,getY()-20,getDirect());
                        break;
                    case 1: //right
                        shot = new Shot(getX()+80,getY()+20,getDirect());
                        break;
                    case 2: //down
                        shot = new Shot(getX()+20,getY()+70,getDirect());
                        break;
                    case 3: //left
                        shot = new Shot(getX()-10,getY()+20,getDirect());
                        break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                shots.add(shot);//将子弹加入Vector
                new Thread(shot).start();//启动该子弹线程
            }

            //先使tank沿原方向移动
            switch (getDirect()){
                case 0:
                    for (int i = 0; i < 50; i++) {
                        moveUp();  //用循环保证tank在该路径上多走几步
                        try {      //每走一步都休眠一次 这样保证50步不会一次性走完(瞬移)
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 50; i++) {
                        moveRight();
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    break;
                case 2:
                    for (int i = 0; i < 50; i++) {
                        moveDown();
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 50; i++) {
                        moveLeft();
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }

            //休眠过后 改变方向 采用随机数方法
            setDirect((int)(Math.random()*4));
            if (!isLive){
                System.out.println("被击中退出");
                break;
            }

        }
    }
}
