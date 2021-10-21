package com.tommychan.date_;
/**
 * LocalDateTime 第三代日期类
 * DateTimeFormatter 格式日期类 ~ 类似于 SimpleDateFormat
 */

import java.time.Instant;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDate01 {
    public static void main(String[] args) {

        //1. 用 LocalDateTime 的now获取当前时间
        LocalDateTime localDate = LocalDateTime.now();
        System.out.println(localDate);

        System.out.println("Year:"+localDate.getYear());
        System.out.println("Month:"+localDate.getMonth());
        System.out.println("Month:"+localDate.getMonthValue());
        System.out.println("Day:"+localDate.getDayOfMonth());
        System.out.println("Day:"+localDate.getDayOfWeek());
        System.out.println("Hour:"+localDate.getHour());
        System.out.println("Minute:"+localDate.getMinute());
        System.out.println("Second:"+localDate.getSecond());
        // LocalDate 只有年月日
        // LocalTime 只有时分秒

        //2. DateTimeFormatter 格式日期类
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH小时mm分钟ss秒");
        String s = dtf.format(localDate);
        System.out.println(s);

        //3. Instant时间戳
        //(1)通过静态方法 now() 获取当前时间戳的对象
        Instant now = Instant.now();
        System.out.println(now);
        //(2)通过 from 可以把Instant转成Date
        Date date = Date.from(now);
        //(3)通过 toInstant 可以吧Date转成Instant
        Instant instant = date.toInstant();

        //4. 第三代日期类更多方法
        //LocalDateTime类
        //MonthDay类：检查重复事件
        //是否是闰年
        //增加日期的某个部分
        //使用plus方法测试增加时间的某个部分
        //使用minus方法测试查看一年前和一年后的日期



    }
}
