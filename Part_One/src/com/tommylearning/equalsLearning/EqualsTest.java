package com.tommylearning.equalsLearning;

public class EqualsTest {
    public static void main(String[] args) {
        "hello".equals("abc"); //查看方法源代码，选中方法名，按住 Ctrl+B
        A a = new A();
        A b = new A();
        a.equals(b);
    }
}

class A{}
