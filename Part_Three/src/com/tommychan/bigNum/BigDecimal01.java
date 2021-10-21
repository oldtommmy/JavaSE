package com.tommychan.bigNum;

import java.math.BigDecimal;

public class BigDecimal01 {
    public static void main(String[] args) {

        //当我们需要保存一个精度很高的数 double不够用
        //我们使用BigDecimal
        BigDecimal bigDecimal = new BigDecimal("9.99999999999999999");
        BigDecimal bigDecimal1 = new BigDecimal("0.00000000000000001");
        System.out.println(bigDecimal);

        //对BigDecimal进行加减乘除需要用对应的方法 不能使用+-*/
        //1. add 加
        bigDecimal = bigDecimal.add(bigDecimal1);
        System.out.println(bigDecimal);

        //2. subtract 减
        bigDecimal = bigDecimal.subtract(bigDecimal1);
        System.out.println(bigDecimal);

        //3. multiply 乘
        bigDecimal = bigDecimal.multiply(bigDecimal1);
        System.out.println(bigDecimal);

        //4. divide 除
        //bigDecimal = bigDecimal.divide(bigDecimal1);
        //可能会抛出异常 (除不尽时 无限循环小数)
        //可以通过指定精度 BigDecimal.Round_CEILING 保留为 分子 的精度
        bigDecimal = bigDecimal.divide(bigDecimal1,BigDecimal.ROUND_CEILING);
        System.out.println(bigDecimal);

    }
}
