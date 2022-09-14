package com.tw.step.assignment1;

public class Rectangle {
    private final double height;
    private final double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double area() {
        return height * width;
    }


    public double perimeter() {
        return (height * 2) + (width * 2);
    }
}
