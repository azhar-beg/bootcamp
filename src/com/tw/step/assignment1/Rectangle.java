package com.tw.step.assignment1;

import com.tw.step.assignment1.exception.InvalidSideException;

public class Rectangle {
    private final double height;
    private final double width;

    private Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double area() {
        return height * width;
    }

    public double perimeter() {
        return (height * 2) + (width * 2);
    }

    public static Rectangle createRectangle(double height, double width) throws InvalidSideException {
        if (height <= 0 || width <= 0) {
            throw new InvalidSideException(height, width);
        }
        return new Rectangle(height, width);
    }

    public static Rectangle createSquare(double side) throws InvalidSideException {
        if (side <= 0) {
            throw new InvalidSideException(side);
        }
        return new Rectangle(side, side);
    }
}
