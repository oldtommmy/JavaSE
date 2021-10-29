package com.tommychan.javaselearning.tankgame02;

import javax.swing.*;
import java.awt.event.KeyListener;

/**
* @author TommyChan
* @version 1.0
* description: TankGame
*/
public class TankGame02 extends JFrame {

    MyPanel myPanel = null;
    public static void main(String[] args) {
        new TankGame02();
    }

    public TankGame02(){
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(1400,1000);
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
