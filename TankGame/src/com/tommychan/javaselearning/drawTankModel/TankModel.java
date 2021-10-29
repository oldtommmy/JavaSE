package com.tommychan.javaselearning.drawTankModel;

import javax.swing.*;
import java.awt.*;

public class TankModel extends JFrame{
    private MyPanel myPanel = null;
    public static void main(String[] args) {
        new TankModel();
    }

    public TankModel(){
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(1400,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.lightGray);
        g.fillRect(500,500,30,40); //主体部分
        g.setColor(Color.darkGray);
        g.fillRect(495,485,10,70); //轮胎
        g.fillRect(530,485,10,70);
        g.fillRect(512,465,8,35);
        g.fillOval(510,510,15,15);
    }
}
