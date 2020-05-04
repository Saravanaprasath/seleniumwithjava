package org.saravana.learntestng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataParameterization {

    @Test
    @Parameters("Name")
    public void printName(String testName){
        System.out.println("Name is "+testName);
    }

    @Test
    @Parameters({"Name","age"})
    public void printNameAndAge(String testName,String testAge){
        System.out.println("Name is "+testName+" "+"Age is "+testAge);
    }
}
