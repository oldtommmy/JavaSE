package com.tommychan.date_;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *  Date 类使用方法
 */
public class Date01 {
    public static void main(String[] args) throws ParseException {


        Date date = new Date(); //获取当前时间
        System.out.println("Date:"+date); //默认输出格式为国外方式
        Date date1 = new Date(232390);//通过毫秒数获取时间
        System.out.println(date1);

        //创建SimpleDateFormat对象，可以指定对应的格式
        //这里的格式中使用的字母是严格规定的，参照api或data_包下的jpg
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm::ss E");
        String format = simpleDateFormat.format(date);
        System.out.println("Date:"+format);

        //把一个格式化的String转换成对应的Date
        //得到的 date2 还是国外的格式
        //可以通过上面的方法转换来格式化输出
        String s = "2020年12月23日 12::23::23 星期日";
        Date date2 = simpleDateFormat.parse(s);
        System.out.println(simpleDateFormat.format(date2));
    }
}
