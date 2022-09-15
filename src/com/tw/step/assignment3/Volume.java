package com.tw.step.assignment3;

public class Volume {
    private final double value;
    private final VolumeUnit volumeUnit;

    public Volume(double value, VolumeUnit volumeUnit) {
        this.value = value;
        this.volumeUnit = volumeUnit;
    }

    public int compare(Volume anotherVolume) {
        double cmDiff = this.getLitreValue() - anotherVolume.getLitreValue();

        return Double.compare(cmDiff, 0);
    }

    private double getLitreValue() {
        return this.volumeUnit.toLitre(this.value);
    }
}
