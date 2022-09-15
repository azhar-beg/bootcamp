package com.tw.step.assignment3;

public enum Unit {
    FEET(30.48), INCHES(2.54), CM(1), MM(0.1);

    private final double cmValue;

    Unit(double cmValue) {
        this.cmValue = cmValue;
    }

    public double getCmValue() {
        return cmValue;
    }
}
