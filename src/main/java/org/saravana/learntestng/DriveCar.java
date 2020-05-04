package org.saravana.learntestng;

import org.testng.annotations.Test;

public class DriveCar {

    @Test(priority = 0)
    public void startTheCar(){
        System.out.println("Start the car");
    }

    @Test(priority = 1)
    public void putFirstGear(){
        System.out.println("Put first gear");
    }

    @Test(priority = 2,enabled = true)
    public void putSecondGear(){
        System.out.println("Put second gear");
    }

    @Test(priority = 3)
    public void putThirdGear(){
        System.out.println("Put third gear");
    }

    @Test(priority = 4)
    public void putFourthGear(){
        System.out.println("Put fourth gear");
    }
}
