package com.tommylearning.exBankAccount;

public class CheckingAmount extends BankAccount {
    public CheckingAmount(double balance) {
        super(balance);
    }

    //在上面的类基础上拓展 此类将在每次存款与取款时收 1 dollar 手续费
    @Override
    public void deposit(double amount) {//存款
        super.deposit(amount - 1);
    }

    @Override
    public void withdraw(double amount) { //取款
        super.withdraw(amount + 1);
    }
}
