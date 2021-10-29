package com.tommychan.javaselearning.tankgame03;

import java.util.Vector;

/**
* @author TommyChan
* @version 3.0
* description: Tank Player
*/
public class Player extends Tank {

    private Shot shot = null;
    private int life = 1;
    private Vector<Shot> shots= new Vector<>();
    public Player(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }

    public void lifeDown(){
        life--;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void shotEnemy(){
        if (shots.size()>=4){
            return;
        }

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
        shots.add(shot);
        new Thread(shot).start();
    }

    public int getLife() {
        return life;
    }

    public Vector<Shot> getShots() {
        return shots;
    }

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }
}
