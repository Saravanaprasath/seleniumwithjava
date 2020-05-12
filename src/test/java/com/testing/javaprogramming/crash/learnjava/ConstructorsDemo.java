package com.testing.javaprogramming.crash.learnjava;

public class ConstructorsDemo {
    String studentName;
    int rollNo;
    Integer age;

    public static void main(String[] args) {
        ConstructorsDemo student = new ConstructorsDemo();
        System.out.println(student.studentName);
        System.out.println(student.rollNo);
        System.out.println(student.age);
    }
}
