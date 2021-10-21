package com.tommylearning.exBankAccount;

public class test {
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount(3000);
        savingAccount.deposit(1000);
        savingAccount.deposit(1000);
        savingAccount.deposit(1000);
        System.out.println(savingAccount.getBalance());
        System.out.println("one month passed");
        savingAccount.earnMonthlyInterest();
        System.out.println(savingAccount.getBalance());

    }
}
