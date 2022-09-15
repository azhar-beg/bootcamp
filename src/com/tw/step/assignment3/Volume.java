package com.tw.step.assignment3;

import com.tw.step.assignment3.exception.NegativeLengthException;

public class Volume {
    private final double value;
    private final VolumeUnit unit;

    private Volume(double value, VolumeUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Volume create(double value, VolumeUnit unit) {
        return new Volume(value, unit);
    }

    public int compare(Volume anotherVolume) {
        double cmDiff = this.getLitreValue() - anotherVolume.getLitreValue();

        return Double.compare(cmDiff, 0);
    }

    public Volume add(Volume anotherVolume)  {
        double value = this.unit.toLitre(this.value) + anotherVolume.unit.toLitre(anotherVolume.value);
        return create(value,VolumeUnit.LITRE);
    }

    public boolean isValueWithinDelta(Volume anotherVolume, double delta) {
        return  Math.abs(this.value - anotherVolume.value) <= delta;
    };

    private double getLitreValue() {
        return this.unit.toLitre(this.value);
    }
}
