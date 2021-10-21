package com.tommychan.exception_;
/** 异常 exception 的引入案例 */
public class Exception_Induct {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 0;

        double result = 0;
        try {                       // n1/n2时 n2 = 0 程序会抛出异常 ArithmeticException 并终止运行
            result = n1/n2;         // 如此一来 程序的健壮性比价差
        } catch (Exception e) {     // java设计者提供了 异常处理机制 来解决该问题
            e.printStackTrace();    // 当程序员认为某段代码可能出现异常 可用try-catch异常处理机制来解决
        }                           // 快捷键为 ctrl + alt + T
        System.out.println("Program continues"); //即使出现异常 程序也可以继续执行
        System.out.println("Result:"+result);
    }
}
