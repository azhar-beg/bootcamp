package com.tw.step.assignment1;

public class Square {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    public double area(){
        return  Math.pow(this.side, 2);
    }

    public double perimeter(){
        return  this.side * 4;
    }
}
