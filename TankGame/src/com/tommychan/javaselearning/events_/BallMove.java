package com.tommychan.javaselearning.events_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
* @author TommyChan
* @version 1.0
* description: To Make Ball Move
*/
public class BallMove extends JFrame {
    MyPanel myPanel = null;
    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove(){
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(1400,1000);
        this.addKeyListener(myPanel);//窗口JFrame 对象可以监听键盘事件 即可以监听面板发生的键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel implements KeyListener { //KeyListener是一个监听器 可监听键盘事件

    int x = 600;//设置初始坐标 方便更新小球位置
    int y = 500;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,80,80);
    }


    //有字符输出时 该方法触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当某个键按下 该方法触发
    @Override
    public void keyPressed(KeyEvent e) {
        //根据按下的不同键处理移动
        //在Java中给每个键分配了一个值
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            y+=5;
            this.repaint();
        }else if (e.getKeyCode() == KeyEvent.VK_UP){
            y-=5;
            this.repaint();
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            x+=5;
            this.repaint();
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x-=5;
            this.repaint();
        }
    }

    //当某个键释放（松开） 该方法触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}