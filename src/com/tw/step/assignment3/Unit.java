package com.tw.step.assignment3;

public enum Unit {
    FEET(30), INCH(2.5), CM(1), MM(0.1);

    private final double cmValue;

    Unit(double cmValue) {
        this.cmValue = cmValue;
    }

    public double toCM(double value) {
        return this.cmValue * value;
    }
}
