package com.tommylearning.exBankAccount;

public class SavingAccount extends BankAccount {
    private int times = 3;
    private double rate = 0.01;

    public SavingAccount(double balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {//存款
        if(times>0){
            super.deposit(amount);
            times--;
        }else{
            super.deposit(amount-1);
        }

    }

    @Override
    public void withdraw(double amount) {
        if (times>0){
            super.withdraw(amount);
            times--;
        }else{
            super.withdraw(amount+1);
        }
    }

    public void earnMonthlyInterest(){
        super.deposit(getBalance()*rate); //用于计算每月的收益 并通过调用父类的deposit方法实现
        times = 3;
    }
}
