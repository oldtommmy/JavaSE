package com.tommychan.javaselearning.draw;

import javax.swing.*;
import java.awt.*;

/**
 * 演示如何在面板画圆
 */
public class DrawCircle extends JFrame{ //JFrame 对应一个窗口，可以理解为画框
    //定义一个面板
    private MyPanel myPanel = null;
    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle(){//构造器
        //初始化面板
        myPanel = new MyPanel();
        //把面板放入画框
        this.add(myPanel);
        //设置窗口大小
        this.setSize(800,800);

        //当点击窗口关闭按键 程序将退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); //使其可以显示
    }
}
//1.先定一个MyPanel，继承JPanel类，画图都在面板上画
//class MyPanel extends JPanel {
//
//    //(1)MyPanel的对象是一个画板
//    //(2)Graphics 是一个画笔
//    //(3)Graphics 提供了很多画图的方法
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        System.out.println("paint is called");
//        g.drawOval(30,30,200,200);
//    }
//
//}