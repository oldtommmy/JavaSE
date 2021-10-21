package com.tommychan.learning.finalDetails;

public class Final01 {
    public static void main(String[] args) {

    }
}

final class A {   //(1)

}

//class B extends A{
//
//}

class C {           //(2)不希望父类C的hi()被子类D覆盖/重写（override）用final关键字修饰。
    public final void hi(){
        System.out.println("C hi() is called");
    }
}
class D extends C{

//    public void hi() {
//        System.out.println("D hi() is called");
//    }
}

class E {  //(3)当不希望类的的某个属性的值被修改，可以用final修饰.
    public final double TAX_RATE = 0.08;
}

class F {  /**(4)当不希望某个局部变量被修改，可以使用final修饰**/
    public void get_Rate(){
        final double RATE = 0.08;
        //RATE = 0.09;
    }
}