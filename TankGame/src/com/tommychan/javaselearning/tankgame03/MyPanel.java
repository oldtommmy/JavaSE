package com.tommychan.javaselearning.tankgame03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author TommyChan
 * @version 3.0
 * description:  Map (panel) of the game
 */
@SuppressWarnings({"all"})
public class MyPanel extends JPanel implements KeyListener , Runnable{ //通过将MyPanel实现Runnable接口
    //定义一个tank                                                      //以线程的方式实现repaint的循环
    Player player = null;

    //考虑到Enemy较多 我们放入一个集合存放
    //而考虑到线程同步安全 我们使用Vector
    Vector<Enemy> enemies = new Vector<>();

    //当子弹击中tank 则加入一个Bomb对象到Vector
    Vector<Bomb> bombs = new Vector<>();

    //用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {
        player = new Player(650,800,0,5); //初始化Player

        int EnemySize = 3;
        for (int i = 0; i < EnemySize; i++) {
            //创建敌人tank
            Enemy enemy = new Enemy(200+200*i,100,2,1);
            //启动enemy线程 实现自由移动
            new Thread(enemy).start();
            //给tank加入一颗子弹
            Shot shot = new Shot(enemy.getX()+20, enemy.getY()+60,enemy.getDirect());
            enemy.getShots().add(shot);
            //启动子弹线程
            new Thread(shot).start();
            enemies.add(enemy);
        }

        //初始化爆炸图片
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

    }

    //创建画板 绘制游戏界面
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1400,1000); //填充背景
        if (player.getLife()>0){
            drawTank(player.getX(),player.getY(),g,player.getDirect(),0);
        }

        //画出player射击的子弹
//        if (player.getShots()!=null && player.getShots().isLive()){
//            g.fill3DRect(player.getShots().getX(),player.getShots().getY(),4,4,false);
//        }

        //通过遍历画出player射击的子弹
        for (int i = 0; i < player.getShots().size(); i++) {
            Shot shot = player.getShots().get(i);
            if (shot!=null && shot.isLive()){
                g.fill3DRect(shot.getX(),shot.getY(),4,4,false);
            }else {
                player.getShots().remove(shot);
            }
        }

        //如果Vector中有对象 则画出爆炸效果
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);

            if (bomb.getLife()>6){
                g.drawImage(image1,bomb.getX(),bomb.getY(),50,50,this);
            }else if (bomb.getLife()>3){
                g.drawImage(image2,bomb.getX(),bomb.getY(),50,50,this);
            }else {
                g.drawImage(image3,bomb.getX(),bomb.getY(),50,50,this);
            }

            bomb.lifeDown();
            if (!bomb.isLive()){
                bombs.remove(bomb);
            }
        }


        for (int i = 0; i < enemies.size(); i++) {
            //遍历画出Vector中的每个Enemies
            if (!enemies.get(i).isLive()) continue;
            drawTank(enemies.get(i).getX(),enemies.get(i).getY(),g,enemies.get(i).getDirect(),1);
            //遍历画出该enemy的Vector中所有子弹
            Vector<Shot> shots = enemies.get(i).getShots();
            for (int j = 0; j < shots.size(); j++) {
                Shot shot = shots.get(j);
                if (shot.isLive()){
                    g.fill3DRect(shot.getX(),shot.getY(),4,4,false);
                }else {
                    enemies.get(i).getShots().remove(shot);
                }
            }
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
                g.drawLine(x+20,y+20,x+20,y-10);//炮
                break;
            case 1://right
                g.fill3DRect(x,y,70,10,false);//左轮
                g.fill3DRect(x,y+30,70,10,false);//右轮
                g.fill3DRect(x+10,y+10,40,20,false);//主体
                g.fillOval(x+20,y+10,20,20);//圆
                g.drawLine(x+50,y+20,x+80,y+20);//炮
                break;
            case 2://down
                g.fill3DRect(x,y,10,70,false);//左轮
                g.fill3DRect(x+30,y,10,70,false);//右轮
                g.fill3DRect(x+10,y+10,20,40,false);//主体
                g.fillOval(x+10,y+20,20,20);//圆
                g.drawLine(x+20,y+40,x+20,y+70);//炮
                break;
            case 3://left
                g.fill3DRect(x,y,70,10,false);//左轮
                g.fill3DRect(x,y+30,70,10,false);//右轮
                g.fill3DRect(x+20,y+10,40,20,false);//主体
                g.fillOval(x+30,y+10,20,20);//圆
                g.drawLine(x+20,y+20,x-10,y+20);//炮
                break;
        }
    }

    public void tankHit(Shot shot , Enemy enemy){
        //判断shot是否击中坦克
        switch (enemy.getDirect()){
            case 0://向上和向下
            case 2:
                if (shot.getX()>enemy.getX() && shot.getX()<enemy.getX()+40
                        &&shot.getY()>enemy.getY()&&shot.getY()<enemy.getY()+60){
                    shot.setLive(false);
                    enemy.setLive(false);
                    Bomb bomb = new Bomb(enemy.getX(), enemy.getY());
                    bombs.add(bomb);
                }
                break;
            case 1://向左和向右
            case 3:
                if (shot.getX()>enemy.getX() && shot.getX()<enemy.getX()+60
                        &&shot.getY()>enemy.getY()&&shot.getY()<enemy.getY()+40){
                    shot.setLive(false);
                    enemy.setLive(false);
                    Bomb bomb = new Bomb(enemy.getX(), enemy.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    public void isPlayerHit(Shot shot , Player player){
        //判断shot是否击中坦克
        switch (player.getDirect()){
            case 0://向上和向下
            case 2:
                if (shot.getX()>player.getX() && shot.getX()<player.getX()+40
                        &&shot.getY()>player.getY()&&shot.getY()<player.getY()+60){
                    shot.setLive(false); //若击中 则子弹线程结束
                    player.lifeDown();   //player生命减1
                    if (player.getLife()<=0){ //若生命值为0 则展示爆炸图案
                        Bomb bomb = new Bomb(player.getX(), player.getY());
                        bombs.add(bomb);
                    }
                }
                break;
            case 1://向左和向右
            case 3:
                if (shot.getX()>player.getX() && shot.getX()<player.getX()+60
                        &&shot.getY()>player.getY()&&shot.getY()<player.getY()+40){
                    shot.setLive(false);
                    player.lifeDown();
                    if (player.getLife()<=0){
                        Bomb bomb = new Bomb(player.getX(), player.getY());
                        bombs.add(bomb);
                    }
                }
                break;
        }
    }

    public void isEscape(Vector<Enemy> enemies, Player player){

        //先对Enemy进行判断
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if (enemy.getX()<=5){
                enemy.setX(5);
            }
            if (enemy.getX()>=1310){
                enemy.setX(1310);
            }

            if (enemy.getY()<=5){
                enemy.setY(5);
            }else if (enemy.getY()>=880){
                enemy.setY(880);
            }
        }


        if (player.getX()<=5){
            player.setX(5);
        }
        if (player.getX()>=1310){
            player.setX(1310);
        }

        if (player.getY()<=5){
            player.setY(5);
        }else if (player.getY()>=880){
            player.setY(880);
        }

    }

    @Override
    public void run() {//每100ms 刷新一次绘图区域 实现子弹移动

        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //如果子弹还存在 则判断子弹是否击中坦克
            if (player.getShot()!=null&&player.getShot().isLive()){

                for (int j = 0; j < player.getShots().size(); j++) {
                    Shot shot = player.getShots().get(j);
                    for (int i = 0; i < enemies.size(); i++) { //对每个坦克都进行判断
                        if (enemies.get(i).isLive()) {  //如果某个坦克已经被击中 则该位置不能参与判断
                            tankHit(shot,enemies.get(i));
                        }
                    }
                }
            }

            //对每个enemy的子弹进行判断是否击中player
            for (int i = 0; i < enemies.size(); i++) {
                Enemy enemy = enemies.get(i);
                for (int j = 0; j < enemy.getShots().size(); j++) {
                    if (enemy.getShots().get(j).isLive()){
                        isPlayerHit(enemy.getShots().get(j),player);
                    }
                }
            }

            isEscape(enemies,player);

            this.repaint();
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

        if (e.getKeyCode() == KeyEvent.VK_J){
                player.shotEnemy();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
