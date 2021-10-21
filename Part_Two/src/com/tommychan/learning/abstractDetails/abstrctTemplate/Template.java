package com.tommychan.learning.abstractDetails.abstrctTemplate;

import static java.lang.System.currentTimeMillis;
//(1)设计一个抽象类Template，能完成如下功能：方法calculateTime()，可以计算某段代码的耗时时间，编写抽象方法job()完成某项工作
//(2)编写一个子类Sub，继承抽象类Template，并实现job方法。
//(3)编写一个测试类TestTemplate，看看是否好用。
abstract public class Template {

    public long calculateTime(){
        long start = currentTimeMillis(); //获取开始时间 java.lang.System.currentTimeMillis;
        job(); //动态绑定机制 -> Sub类
        long end = currentTimeMillis();//获取结束时间
        return end-start;
    }

    abstract void job();
}
