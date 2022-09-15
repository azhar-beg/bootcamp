package com.tw.step.assignment3;

public enum Unit {
    FEET(0.3), INCH(0.025), CM(0.01), MM(0.001);

    private final double siValue;

    Unit(double sIValue) {
        siValue = sIValue;
    }
}
