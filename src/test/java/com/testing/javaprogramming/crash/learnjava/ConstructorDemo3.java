package com.testing.javaprogramming.crash.learnjava;

public class ConstructorDemo3 {

    String animalName;
    String animalType;


    ConstructorDemo3(String name,String type){
            animalName = name;
            animalType = type;
    }

    public void sayAboutName(){
        System.out.println("Animal Name is "+animalName);
        System.out.println("Animal Type is "+animalType );
    }

    public static void main(String[] args) {
        ConstructorDemo3 animal = new ConstructorDemo3("Duck","Omnivores");
        animal.sayAboutName();
    }

}
