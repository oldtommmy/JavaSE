package com.tommychan.string_;

public class Exercise02 {
    public static void main(String[] args) {
        String name = "Chen yuanhang";
        System.out.println("name:"+showName(name));
    }

    public static String showName(String name){
        int begin = name.indexOf(' ');
        int end = name.lastIndexOf(' ');
        return new String(name.substring(begin+1,begin+2).toUpperCase()+
                name.substring(begin+2,name.length())+" "+
                name.substring(0,begin));
    }
}
