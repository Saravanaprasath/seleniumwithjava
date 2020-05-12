package com.testing.javaprogramming.crash.learnjava;

public class CollectAmount {
    public Integer collectedAmount = 1000;

    public Integer collectAmountAndGiveItToMe(){
        System.out.println("Daddy have collected rupees " +collectedAmount + " and sent it to you");
        return collectedAmount;
    }

    public static void main(String[] args) {
        CollectAmount son = new CollectAmount();
        Integer amount = son.collectAmountAndGiveItToMe();
        System.out.println("Got the amount " + amount);
    }
}
