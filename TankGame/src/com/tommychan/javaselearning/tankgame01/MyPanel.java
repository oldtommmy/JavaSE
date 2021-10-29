package com.tommychan.javaselearning.tankgame01;

import javax.swing.*;
import java.awt.*;

/**
* @author TommyChan
* @version 1.0
* description:  Map (panel) of the game
*/
public class MyPanel extends JPanel {
    //定义一个tank
    Player player = null;
    public MyPanel() {
        player = new Player(650,800);
    }

    //创建画板 绘制游戏界面
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1400,1000); //填充背景
        drawTank(player.getX(),player.getY(),g,0,0);
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
                g.fillOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+30,x+20,y);
        }
    }
}
