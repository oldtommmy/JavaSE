package com.tommychan.learning.interface_.interface_01;

public class Camera implements Usb {
    @Override
    public void start() {
        System.out.println("Camera starts working");
    }

    @Override
    public void stop() {
        System.out.println("Camera stops working");
    }
}
