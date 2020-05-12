package com.testing.javaprogramming.crash.learnjava;

public class ConstructorDemo2 {

    int empId;
    String employeeName;

    //Define a constructor
    ConstructorDemo2(){
        empId =1;
        employeeName = "saravana";
        System.out.println("Employee object is created");
    }

    public static void main(String[] args) {
        ConstructorDemo2 employee = new ConstructorDemo2();

    }
}
