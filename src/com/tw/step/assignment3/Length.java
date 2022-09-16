package com.tw.step.assignment3;

import com.tw.step.assignment3.exception.NegativeLengthException;

public class Length {
    private final double value;
    private final LengthUnit unit;

    private Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Length create(double value, LengthUnit unit) throws NegativeLengthException {
        if (value < 0 ) {
            throw new NegativeLengthException(value);
        }
        return new Length(value, unit);
    }

    public ComparisonResult compare(Length anotherLength) {
        double cmDiff = this.getCmValue() - anotherLength.getCmValue();
//        return ComparisonResult.values()[Double.compare(cmDiff, 0) + 1];

        if (cmDiff > 0){
            return ComparisonResult.GREATER;
        };

        if (cmDiff < 0){
            return ComparisonResult.LESS;
        };

        return ComparisonResult.EQUAL;
    }

    public Length add(Length anotherLength) throws NegativeLengthException {
        double value = this.unit.toInch(this.value) + anotherLength.unit.toInch(anotherLength.value);
        return create(value, LengthUnit.INCH);
    }

    private double getCmValue() {
        return this.unit.toCM(this.value);
    }

    public boolean isValueWithinDelta(Length anotherLength, double delta) {
        return  Math.abs(this.value - anotherLength.value) <= delta;
    };
}
