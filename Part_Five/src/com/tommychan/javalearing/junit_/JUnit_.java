package com.tommychan.javalearing.junit_;

import org.junit.jupiter.api.Test;

public class JUnit_ {
    public static void main(String[] args) {

        //传统方法来测试
        //m1();
        //m2();
    }

    @Test
    public void m1(){
        System.out.println("m1 is called");
    }

    @Test
    public void m2(){
        System.out.println("m2 is called");
    }
}

