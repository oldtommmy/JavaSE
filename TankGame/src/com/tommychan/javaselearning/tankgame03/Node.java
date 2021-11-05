package com.tommychan.javaselearning.tankgame03;
/**
 * @author TommyChan
 * @version 1.0
 * description 一个Node对象表示一个坦克的信息
 */
public class Node {
    private int x;
    private int y;
    private int direct;

    public Node(int x, int y, int direct) {
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
}
