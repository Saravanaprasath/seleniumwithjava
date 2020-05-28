package com.testing.javaprogramming.collectionframework;

import org.testng.annotations.Test;

public class Tests {

    @Test
    public void trim(){
        String text = "₹ 52,500.00";
        //text = text.replaceAll("₹","");
        text = text.replaceAll("\\s|₹|,","");
        //text = text.replaceAll(",","");
        System.out.println(text);
    }

    @Test
    public void compare(){
        double priceAmazon = 52005.02;
        double priceFlipkart = 52005.00;

        int result = Double.compare(priceAmazon,priceFlipkart);
        if(result > 0) {
            System.out.println("Flipkart price is less than the Amazon price");
        } else if(result < 0) {
            System.out.println("Amazon price is less than the Flipkart price");
        } else {
            System.out.println("Amazon price is equal to the Flipkart price");
        }
    }
}
