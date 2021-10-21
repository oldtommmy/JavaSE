package com.tommychan.learning.interface_.interfacePolyPass;

public class PolyPass {
    public static void main(String[] args) {
        //接口类型的变量可以指向 实现该接口的类的实例化对象
        inter_A a = new C();
        inter_B b = new C();

    }
}
// 多态传递
interface inter_A extends inter_B{ } //A接口继承了B接口
interface inter_B{ }                 //意味着如果类C实现了接口A 就业实现了接口B
class C implements inter_A{ }