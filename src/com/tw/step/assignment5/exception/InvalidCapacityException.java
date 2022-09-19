package com.tw.step.assignment5.exception;

public class InvalidCapacityException extends Throwable {
    public InvalidCapacityException(int maxCapacity) {
        super("Invalid capacity: " + maxCapacity + "Please provide valid capacity.");
    }
}
