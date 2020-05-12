package com.testing.javaprogramming.crash.learnjava;

public class Child extends Parent{
    public Child(){
        System.out.println("Child constructor");
    }

    public static void main(String[] args) {
        Child child = new Child();
    }
}
