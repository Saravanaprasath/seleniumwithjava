package org.saravana.learntestng;

import org.testng.annotations.*;

public class HierarchyExample {

    @Test
    public void test() {
        System.out.println("I'm test");
    }

    @Test
    public void testing(){
        System.out.println("I'm testing");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("I'm beforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("I'm afterTest");

    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("I'm beforeMethod");

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("I'm afterMethod");

    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("I'm beforeClass");

    }

    @AfterClass
    public void afterClass() {
        System.out.println("I'm afterClass");

    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("I'm beforeGroups");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("I'm afterGroups");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("I'm beforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("I'm afterSuite");
    }


}
