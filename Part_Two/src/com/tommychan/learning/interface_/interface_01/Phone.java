package com.tommychan.learning.interface_.interface_01;

public class Phone implements Usb {
    @Override
    public void start() {
        System.out.println("Phone starts  working");
    }

    @Override
    public void stop() {
        System.out.println("Phone stops working");
    }
}
