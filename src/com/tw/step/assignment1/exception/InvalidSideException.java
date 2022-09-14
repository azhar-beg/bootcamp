package com.tw.step.assignment1.exception;

public class InvalidSideException extends Throwable {
    private double height;
    private double width;
    private double side;

    public InvalidSideException(double height, double width) {
        super("Invalid Arguments: Please Provide valid height and width");
        this.height = height;
        this.width = width;
    }

    public InvalidSideException(double side) {
        super("Invalid Arguments: Please Provide valid side");
        this.side = side;
    }
}
