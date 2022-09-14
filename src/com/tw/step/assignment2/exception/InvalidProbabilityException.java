package com.tw.step.assignment2.exception;

public class InvalidProbabilityException extends Throwable {
    public InvalidProbabilityException(double probability) {
        super("Invalid Probability: " + probability + ", Please provide probability between 0-1");
    }
}
