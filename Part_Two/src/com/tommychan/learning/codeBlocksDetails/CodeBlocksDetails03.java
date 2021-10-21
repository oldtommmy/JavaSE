package com.tommychan.learning.codeBlocksDetails;

public class CodeBlocksDetails03 {
    public static void main(String[] args) {
        // (1)先进行类加载
        // 1.1 先加载父类E  1.2 再加载子类F
        // (2)创建对象
        F f = new F();
    }
}
//创建一个子类对象时（继承关系），他们的静态代码块，静态属性初始化，普通代码块，普通属性初始化，构造方法的调用顺序
//        1. 父类的静态代码块和静态属性（优先级一样，按定义顺序执行）
//        2. 子类的静态代码块和静态属性（优先级一样，按定义顺序执行）
//        3. 父类的普通代码块和普通属性初始化（优先级一样，按定义顺序执行）
//        4. 父类的构造方法
//        5. 子类的普通代码块和普通属性初始化（优先级一样，按定义顺序执行）
//        6. 子类的构造方法
class E{
    static {                                        //父类的静态代码块
        System.out.println("Father(E)'s static CodeBlocks is called");
    }

    {                                               //父类的普通代码块
        System.out.println("Father(E)'s Normal CodeBlocks is called");
    }
    private static int N2_E = getN2_E();
    private int N_E = getN_E();                      //父类的普通属性初始化

    public int getN_E(){
        System.out.println("public int getN_E() is called");
        return 10;
    }

    public static int getN2_E(){
        System.out.println("public static int getN2_E() is called");
        return 10;
    }

    public E() {                                     //父类的构造方法
        //隐藏了
        //(1)super()
        //(2)普通代码块
        System.out.println("Father(E)'s Constructor is called");
    }
}

class F extends E{
    static {                                        //子类的静态代码块
        System.out.println("Son(F) static CodeBlocks is called");
    }

    {                                               //子类的普通代码块
        System.out.println("Son(F) Normal CodeBlocks is called");
    }

    private static int N2_F = getN2_F();
    private int N_F = getN_F();                      //子类的普通属性初始化

    public int getN_F(){
        System.out.println("public int getN_F() is called");
        return 10;
    }

    public static int getN2_F(){
        System.out.println("public static int getN2_F() is called");
        return 10;
    }

    public F() {                                    //子类的构造方法
        //隐藏了
        //(1)super() -> 去执行父类E的构造器
        //(2)普通代码块
        System.out.println("Son(F)'s Constructor is called");
    }
}