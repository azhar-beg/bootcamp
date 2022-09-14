package com.tw.step.assignment1;

import com.tw.step.assignment1.exception.InvalidArgumentsException;

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

    public static Rectangle create(double height, double width) throws InvalidArgumentsException {
        if (height <= 0 || width <= 0 ){
            throw new InvalidArgumentsException(height , width);
        }
        return new Rectangle(height,width);
    }
}
