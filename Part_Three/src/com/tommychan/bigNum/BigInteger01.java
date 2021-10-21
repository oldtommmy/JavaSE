package com.tommychan.bigNum;

import java.math.BigInteger;

public class BigInteger01 {
    public static void main(String[] args) {

        //创建BigInteger
        BigInteger bigInteger = new BigInteger("29000000000000000000");
        BigInteger bigInteger1 = new BigInteger("1000000000000000000");
        System.out.println(bigInteger);

        //对BigInteger进行加减乘除需要用对应的方法 不能使用+-*/
        //1. add 加
        bigInteger = bigInteger.add(bigInteger1);
        System.out.println(bigInteger);
        //2. subtract 减
        bigInteger = bigInteger.subtract(bigInteger1);
        System.out.println(bigInteger);
        //3. multiply 乘
        //4. divide 除

    }
}
