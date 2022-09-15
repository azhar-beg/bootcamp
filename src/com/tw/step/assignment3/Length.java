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
        double cmDiff = this.getCmValue() - anotherLength.getCmValue();

        return Double.compare(cmDiff, 0);
    }

    private double getCmValue() {
        return this.unit.toCM(this.value);
    }
}
