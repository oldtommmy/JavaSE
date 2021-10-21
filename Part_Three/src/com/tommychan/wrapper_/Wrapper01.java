package com.tommychan.wrapper_;

@SuppressWarnings("all")
public class Wrapper01 {
    public static void main(String[] args) {
        //示例一
        Integer i1=new Integer( 127);
        Integer i2=new Integer( 127);
        System.out.println(i1==i2); //false
        //示例二
        Integer i3=new Integer( 128);
        Integer i4=new Integer( 128);
        System.out.println(i3==i4); //false
        //示例三
        Integer i5=127; //底层用的是Integer.valueOf(127)
        Integer i6=127; //-128~127 就是直接返回 在此范围外则new一个
        System.out.println(i5==i6); //true
        //示例四
        Integer i7=128;
        Integer i8=128;
        System.out.println(i7==i8); //false
        //示例五
        Integer i9=127;
        Integer i10=new Integer(127);
        System.out.println(i9==i10);//false
        //示例六
        Integer i11=127;
        int i12=127;//只要有基本数据类型，判断的是值是否相等
        System.out.println(i11==i12);//true
        //示例七
        Integer i13 =128;
        int i14=128;
        System.out.println(i13==i14);//true
    }
}
