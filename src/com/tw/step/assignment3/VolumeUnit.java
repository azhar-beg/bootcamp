package com.tw.step.assignment3;

public enum VolumeUnit {
    GALLON(3.78), LITRE(1);

    private final double litreValue;

    VolumeUnit(double litreValue) {
        this.litreValue = litreValue;
    }

    public double toLitre(double value) {
        return this.litreValue * value;
    }
}
