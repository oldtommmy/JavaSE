package com.tommychan.learning.interface_.interface_02;

public class MysqlDB implements DBInterface {
    @Override
    public void connect() {
        System.out.println("MysqlDB is connect");
    }

    @Override
    public void close() {
        System.out.println("MysqlDB is closed");
    }
}
