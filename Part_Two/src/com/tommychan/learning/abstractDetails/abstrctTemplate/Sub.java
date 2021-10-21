package com.tommychan.learning.abstractDetails.abstrctTemplate;
//(2)编写一个子类Sub，继承抽象类Template，并实现job方法。
public class Sub extends Template{
    public void job(){
        long sum = 0;
        for (long i = 0; i < 800000; i++) {
            sum += i;
        }
    }
}
