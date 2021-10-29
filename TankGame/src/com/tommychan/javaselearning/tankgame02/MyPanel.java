package com.tommychan.javaselearning.tankgame02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author TommyChan
 * @version 1.0
 * description:  Map (panel) of the game
 */
public class MyPanel extends JPanel implements KeyListener {
    //定义一个tank
    Player player = null;

    //考虑到Enemy较多 我们放入一个集合存放
    //而考虑到线程同步安全 我们使用Vector
    Vector<Enemy> enemies = new Vector<>();

    public MyPanel() {
        player = new Player(650,800,0,5); //初始化Player

        int EnemySize = 3;
        for (int i = 0; i < EnemySize; i++) {
            enemies.add(new Enemy(200+200*i,100,2,5));
        }

    }

    //创建画板 绘制游戏界面
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1400,1000); //填充背景
        drawTank(player.getX(),player.getY(),g,player.getDirect(),0);

        //画出Enemies
        for (int i = 0; i < enemies.size(); i++) {
            drawTank(enemies.get(i).getX(),enemies.get(i).getY(),g,2,1);
        }
    }

    /**
     *
     * @param x x 坐标
     * @param y y 坐标
     * @param g 画笔
     * @param direct 方向
     * @param type 坦克类型
     */

    //画出tank
    public void drawTank(int x,int y,Graphics g,int direct,int type){

        switch (type){
            case 0: // Player
                g.setColor(Color.yellow);
                break;
            case 1: // Enemy
                g.setColor(Color.LIGHT_GRAY);
                break;
        }

        switch (direct){
            case 0: // up
                g.fill3DRect(x,y,10,70,false);//左轮
                g.fill3DRect(x+30,y,10,70,false);//右轮
                g.fill3DRect(x+10,y+20,20,40,false);//主体
                g.fillOval(x+10,y+30,20,20);//圆
                g.drawLine(x+20,y+40,x+20,y-10);//炮
                break;
            case 1://right
                g.fill3DRect(x,y,70,10,false);//左轮
                g.fill3DRect(x,y+30,70,10,false);//右轮
                g.fill3DRect(x+10,y+10,40,20,false);//主体
                g.fillOval(x+20,y+10,20,20);//圆
                g.drawLine(x+40,y+20,x+80,y+20);//炮
                break;
            case 2://down
                g.fill3DRect(x,y,10,70,false);//左轮
                g.fill3DRect(x+30,y,10,70,false);//右轮
                g.fill3DRect(x+10,y+10,20,40,false);//主体
                g.fillOval(x+10,y+20,20,20);//圆
                g.drawLine(x+20,y+40,x+20,y+80);//炮
                break;
            case 3://left
                g.fill3DRect(x,y,70,10,false);//左轮
                g.fill3DRect(x,y+30,70,10,false);//右轮
                g.fill3DRect(x+20,y+10,40,20,false);//主体
                g.fillOval(x+30,y+10,20,20);//圆
                g.drawLine(x+40,y+20,x-10,y+20);//炮
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理WASD按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W){
            player.setDirect(0);
            player.setY(player.getY()-5);
        }else if (e.getKeyCode() == KeyEvent.VK_D){
            player.setDirect(1);
            player.setX(player.getX()+5);
        }else if (e.getKeyCode() == KeyEvent.VK_S) {
            player.setDirect(2);
            player.setY(player.getY()+5);
        }else if (e.getKeyCode() == KeyEvent.VK_A) {
            player.setDirect(3);
            player.setX(player.getX()-5);
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
