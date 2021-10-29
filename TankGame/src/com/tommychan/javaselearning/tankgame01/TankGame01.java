package com.tommychan.javaselearning.tankgame01;

import javax.swing.*;
/**
* @author TommyChan
* @version 1.0
* description: TankGame
*/
public class TankGame01 extends JFrame {

    MyPanel myPanel = null;
    public static void main(String[] args) {
        new TankGame01();
    }

    public TankGame01(){
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(1400,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
