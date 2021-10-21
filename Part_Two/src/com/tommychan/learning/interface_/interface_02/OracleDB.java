package com.tommychan.learning.interface_.interface_02;

public class OracleDB implements DBInterface{
    @Override
    public void connect() {
        System.out.println("OracleDB is connected");
    }

    @Override
    public void close() {
        System.out.println("OracleDB is closed");
    }
}
