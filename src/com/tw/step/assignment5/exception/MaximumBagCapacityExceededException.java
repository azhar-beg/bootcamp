package com.tw.step.assignment5.exception;

public class MaximumBagCapacityExceededException extends Throwable {
    public MaximumBagCapacityExceededException(int size) {
        super("Maximum Bag capacity exceeded" + size);
    }
}
