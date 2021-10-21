package com.tommychan.learning.finalDetails;

public class FinalDetails01 {
    public static void main(String[] args) {

    }
}
//final修饰的属性在定义时，必须赋初值，并且以后不能再修改，赋值可以在如下位置之一【选择一个位置赋初值即可】：
// 定义时
// 在构造器中
// 在代码块中
class AA{
    public final double TAX_RATE = 0.08; // 定义时
    public final double TAX_RATE2;
    public final double TAX_RATE3;

    public AA() {
        TAX_RATE2 = 0.02; // 在构造器中
    }

    {
        TAX_RATE3 = 0.04; //在代码块中
    }
}


class BB{
    public static final double Oil_RATE = 0.08; // 定义时
    public static final double Oil_RATE2;


    static{
        Oil_RATE2 = 0.09;          //静态代码块中
    }
}