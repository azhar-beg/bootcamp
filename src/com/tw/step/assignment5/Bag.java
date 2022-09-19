package com.tw.step.assignment5;

import com.tw.step.assignment5.exception.InvalidCapacityException;

public class Bag {
    private final int maxCapacity;

    private Bag(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public static Bag create(int maxCapacity) throws InvalidCapacityException {
        if (maxCapacity > 12 || maxCapacity < 1){
            throw new InvalidCapacityException(maxCapacity);
        }
        return new Bag(maxCapacity);
    }
}
