package org.saravana.learntestng;

import org.testng.annotations.Test;

public class Dependency {

    @Test(enabled = true)
    public void highSchool(){
        System.out.println("High school passed");
    }

    @Test(dependsOnMethods = "highSchool")
    public void higherSecSchool(){
        System.out.println("Higher Sec school passed");
    }

    @Test(dependsOnMethods = "higherSecSchool")
    public void engineering(){
        System.out.println("Engineering joined");
    }
}
