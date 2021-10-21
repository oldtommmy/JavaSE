package com.tommychan.enum_;
/**
 * enum关键字来实现枚举类的描述
 */
public class enum02 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
    }
}

enum Season02 {

    //1.enum 代替 class
    //2.public final static Season SPRING = new Season("Spring","Warm");
    //  用 SPRING("Spring","Warm") 解读：常量名(形参)
    //3.如果有多个常量 则用 , 隔开
    //4.用enum，要将定义常量对象写在前面
    //5.若用无参构造器创建，可省略小括号和形参

    SPRING("Spring","Warm"),
    SUMMER("Summer","Hot"),
    FALL("Fall","Cool"),
    WINTER("Winter","Cold"),
    OtherSeason; //调用无参构造器 也可以OtherSeason();


    private String name;
    private String desc;


    private Season02(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    private Season02(){  //无参构造器

    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}


