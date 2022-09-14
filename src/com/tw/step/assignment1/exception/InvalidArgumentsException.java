package com.tw.step.assignment1.exception;

public class InvalidArgumentsException extends Throwable {
    private final double height;
    private final double width;

    public InvalidArgumentsException(double height, double width) {
        super("Invalid Arguments: Please Provide valid height and width");
        this.height = height;
        this.width = width;
    }
}
