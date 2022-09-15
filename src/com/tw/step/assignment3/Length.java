package com.tw.step.assignment3;

public class Length {
    private final double value;
    private final Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public int compare(Length anotherLength) {
        double diff = (this.value * this.unit.getCmValue()) - (anotherLength.value * anotherLength.unit.getCmValue());

        return Double.compare(diff, 0);
    }
}
