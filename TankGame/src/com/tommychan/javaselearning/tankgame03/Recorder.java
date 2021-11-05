package com.tommychan.javaselearning.tankgame03;

import java.io.*;
import java.util.Vector;

/**
 * @author TommyChan
 * @version 1.0
 * description  该类用于记录游戏信息
 */
@SuppressWarnings({"all"})
public class Recorder {

    private static int num = 0;
    //定义IO对象 来写入数据到文件
    private static BufferedWriter bufferedWriter= null; //用于写入数据
    private static BufferedReader bufferedReader = null;//用于读取数据
    private static String recordFile = "src\\myRecord.txt";//保存路径
    private static Vector<Enemy> enemies= null;
    private static Vector<Node> nodes = new Vector<>();

    public static void setEnemies(Vector<Enemy> enemies) {
        Recorder.enemies = enemies;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Recorder.num = num;
    }

    public static Vector getNodesAndEnemies() throws IOException {
        try {
            bufferedReader = new BufferedReader(new FileReader(recordFile));
            num = Integer.parseInt(bufferedReader.readLine());

            String line = "";
            while ((line = bufferedReader.readLine())!=null){
                String[] spilt = line.split(" ");
                Node node = new Node(Integer.valueOf(spilt[0]), Integer.valueOf(spilt[1]),
                                    Integer.valueOf(spilt[2]));
                nodes.add(node);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader!=null){
                bufferedReader.close();
            }
        }
        return nodes;
    }

    public static void recordInfo() {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(recordFile));
            bufferedWriter.write(String.valueOf(num)+"\r\n");

            for (int i = 0; i < enemies.size(); i++) {
                Enemy enemy = enemies.get(i);
                if (enemy.isLive()){
                    String record = enemy.getX()+" "+enemy.getY()+" "+enemy.getDirect();
                    bufferedWriter.write(record+"\r\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter!=null){
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
