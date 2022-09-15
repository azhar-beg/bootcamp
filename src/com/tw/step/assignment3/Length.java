package com.tw.step.assignment3;

import com.tw.step.assignment3.exception.NegativeLengthException;

public class Length {
    private final double value;
    private final Unit unit;

    private Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Length create(double value, Unit unit) throws NegativeLengthException {
        if (value < 0 ) {
            throw new NegativeLengthException(value);
        }
        return new Length(value, unit);
    }

    public int compare(Length anotherLength) {
        double diff = (this.unit.toCM(this.value) - anotherLength.unit.toCM(anotherLength.value));

        return Double.compare(diff, 0);
    }
}
