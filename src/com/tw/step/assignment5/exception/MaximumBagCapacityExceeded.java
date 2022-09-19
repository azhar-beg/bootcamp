package com.tw.step.assignment5.exception;

public class MaximumBagCapacityExceeded extends Throwable {
    public MaximumBagCapacityExceeded(int size) {
        super("Maximum Bag capacity exceeded" + size);
    }
}
