package com.tommychan.javaselearning.tankgame03;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

/**
* @author TommyChan
* @version 3.0
* description: TankGame
*/
public class TankGame03 extends JFrame {

    MyPanel myPanel = null;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        new TankGame03();
    }

    public TankGame03() throws IOException {
        System.out.println("按 C 继续上一次游戏 ，S 重开一局游戏");
        String key = scanner.next();
        myPanel = new MyPanel(key);
        Thread thread = new Thread(myPanel);
        thread.start();
        this.add(myPanel);
        this.setSize(2000,1000);
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("窗口已关闭");
                Recorder.recordInfo();
                System.exit(0);
            }
        });
    }
}
