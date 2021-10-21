package com.tommychan.learning.interface_.interface_01;

public class Interface01 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Camera camera = new Camera();
        Computer computer = new Computer();

        computer.work(phone);
        computer.work(camera);
    }
}
