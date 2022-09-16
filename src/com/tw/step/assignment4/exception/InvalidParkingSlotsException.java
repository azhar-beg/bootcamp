package com.tw.step.assignment4.exception;

public class InvalidParkingSlotsException extends Throwable {
    public InvalidParkingSlotsException(int maxNoOfSlots) {
        super("Invalid Number of slots: " + maxNoOfSlots + ". Please provide valid number of slots");
    }
}
