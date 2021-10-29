package com.tommychan.javalearing.generic_;

public class Generic01 {
    public static void main(String[] args) {
        Test<String> stringTest = new Test<String>("Tommy");
        Test<Integer> integerTest = new Test<>(9);
    }
}

class Test<E>{
    E e; //E 表示 e 的数据类型，该数据类型在定义Test对象的时候指定
         // 即在编译期间就已经确定

    public Test(E e) {
        this.e = e;
    }

    public E getE() {
        return e;
    }
}

