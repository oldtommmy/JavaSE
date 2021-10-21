package com.tommychan.date_;

import java.util.Calendar;

/**
 *  Calendar 类的使用
 */

public class Calender01 {
    public static void main(String[] args) {

        //Calendar 类是一个抽象类 且构造器为private
        //可以通过 getInstance() 来获取实例

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        //获取Calendar对象的某个日历字段
        System.out.println("Year:"+calendar.get(calendar.YEAR));
        System.out.println("Month:"+((calendar.get(calendar.MONTH))+1));
        //Calendar 返回月时 从 0 开始 故+1
        System.out.println("Day:"+calendar.get(calendar.DAY_OF_MONTH));
        System.out.println("Hour:"+calendar.get(calendar.HOUR));
        System.out.println("Minute:"+calendar.get(calendar.MINUTE));
        System.out.println("Second:"+calendar.get(calendar.SECOND));
        //Calender 没有专门的格式化方法，所以需要程序员自己来组合显示

    }
}
