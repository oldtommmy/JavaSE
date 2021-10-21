package com.tommychan.learning.interface_.interface_02;

public class Interface_02 {
    public static void main(String[] args) {
        MysqlDB mysqlDB = new MysqlDB();
        OracleDB oracleDB = new OracleDB();

        t(mysqlDB);
        t(oracleDB);
    }

    public static void t(DBInterface dbInterface){
        dbInterface.connect();
        dbInterface.close();
    }
}
