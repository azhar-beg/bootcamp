package com.tw.step.assignment3.exception;

public class NegativeLengthException extends Throwable {
    public NegativeLengthException(double value) {
        super("Negative Length Error: " + value + ", please provide valid length.");
    }
}
