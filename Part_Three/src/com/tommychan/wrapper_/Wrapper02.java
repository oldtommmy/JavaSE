package com.tommychan.wrapper_;

public class Wrapper02 {
    public static void main(String[] args) {
        //包装类（Integer）-> String
        Integer i = 100;
        //方法1
        String s1 = i+"";
        //方法2
        String s2 = i.toString();
        //方法3
        String s3 = String.valueOf(i);

        //String -> Integer
        String s = "111";
        //方法1
        Integer i1 = Integer.parseInt(s);
        //方法2
        Integer i2  = new Integer(s);
    }
}
