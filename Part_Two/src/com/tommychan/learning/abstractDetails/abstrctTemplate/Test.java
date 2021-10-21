package com.tommychan.learning.abstractDetails.abstrctTemplate;
//(3)编写一个测试类Test，看看是否好用。
public class Test {
    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println("Sub's job needs "+sub.calculateTime()+" ms");
    }
}
