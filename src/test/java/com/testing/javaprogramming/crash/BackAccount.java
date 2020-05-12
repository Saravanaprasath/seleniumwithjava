package com.testing.javaprogramming.crash;

public class BackAccount {
    Long accNumber = 9856232145785l;
    String accHolderName = "Saravana";
    int accBalance = 3500;

    public void getBalance(){
        System.out.println(accBalance);
    }



    public static void main(String[] args) {
        BackAccount backAccount = new BackAccount();
        backAccount.getBalance();
    }
}
