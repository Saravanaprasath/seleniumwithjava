package com.testing.javaprogramming.crash.learnjava;

public class Draw {
    String draw;

    Draw() {
        System.out.println("No argument constructor - draw");
    }

    Draw(String toDraw) {
        draw = toDraw;
        System.out.println("Drawing " + draw);
        System.out.println("Parameterized Constructor - draw");
    }

    public static void main(String[] args) {
        Draw draw = new Draw();
        Draw draw1 = new Draw("Circle");

    }
}
