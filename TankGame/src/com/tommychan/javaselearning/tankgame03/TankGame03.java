package com.tommychan.javaselearning.tankgame03;

import javax.swing.*;

/**
* @author TommyChan
* @version 3.0
* description: TankGame
*/
public class TankGame03 extends JFrame {

    MyPanel myPanel = null;
    public static void main(String[] args) {
        new TankGame03();
    }

    public TankGame03(){
        myPanel = new MyPanel();
        Thread thread = new Thread(myPanel);
        thread.start();
        this.add(myPanel);
        this.setSize(1400,1000);
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
