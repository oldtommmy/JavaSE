package com.tommychan.javaselearning.draw;

import javax.swing.*;
import java.awt.*;

public class GraphicsMethod extends JFrame{

    //定义一个面板
    private MyPanel myPanel = null;
    public static void main(String[] args) {
        new GraphicsMethod();
    }

    public GraphicsMethod(){
        //初始化面板
        myPanel = new MyPanel();
        this.add(myPanel);
        //设置窗口大小
        this.setSize(1500,1500);

        //当点击窗口关闭按键 程序将退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); //使其可以显示
    }
}

class MyPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //画直线drawLine(int x1,int y1,int x2,int y2)
        g.drawLine(30,30,200,30);

        //画矩形边框drawRect(int x, int y, int width, int height)
        g.drawRect(30,110,100,80);

        //画椭圆边框drawOval(int x, int y, int width, int height)
        g.drawOval(150,150,100,200);

        //填充矩形fillRect(int x, int y, int width, int height)
        g.setColor(Color.YELLOW);
        g.fillRect(400,400,80,80);

        //填充椭圆fillOval(int x, int y, int width, int height)


        //画图片drawImage(Image img, int x, int y, ..)
        //(1)获取图片资源 /Cat.JPG 表示在该项目的根目录去获取 /Cat.JPG 图片资源
        Image cat = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Cat.JPG"));
        g.drawImage(cat,20,500,634,626,this);


        //画字符串drawString(String str, int x, int y)
        g.setColor(Color.red);
        g.setFont(new Font("微软雅黑",Font.BOLD,30));
        g.drawString("猫猫在这里",20,450); //20 450 是String的左下角


        //设置画笔的字体setFont（Font font）


        //设置画笔的颜色setColor(Color c)
    }
}





