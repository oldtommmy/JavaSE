package com.tommychan.javaselearning.tankgame02;
/**
* @author TommyChan
* @version 1.0
* description: tank
*/
public class Tank {
    private int x;
    private int y;
    private int direct; // 0 1 2 3
    private int speed;

    public void moveUp(){
        y -= speed;
    }

    public void moveDown(){
        y += speed;
    }

    public void moveLeft(){
        x -= speed;
    }

    public void moveRight(){
        x += speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getDirect() {
        return direct;
    }

    public int getSpeed() {
        return speed;
    }

    public Tank(int x, int y, int direct, int speed) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
