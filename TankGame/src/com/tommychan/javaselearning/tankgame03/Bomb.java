package com.tommychan.javaselearning.tankgame03;

public class Bomb {
    private int x;
    private int y;
    private int life = 10;
    private boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown(){ //通过生命值的大小来输出不同的图片
        if (life > 0){      //以实现爆炸的动态效果
            life--;
        }else {
            isLive = false;
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLife() {
        return life;
    }

    public boolean isLive() {
        return isLive;
    }
}
