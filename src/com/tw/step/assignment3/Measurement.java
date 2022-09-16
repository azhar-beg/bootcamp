//package com.tw.step.assignment3;
//
//abstract public class Measurement <T>{
//    private final double value;
//    private final T unit;
//
//    public Measurement(double value, T unit) {
//        this.value = value;
//        this.unit = unit;
//    }
//
//    public int compare(Measurement<T> anotherMeasurement) {
//        double cmDiff = this.getSIUnitValue() - anotherMeasurement.getSIUnitValue();
//
//        return Double.compare(cmDiff, 0);
//    }
//
//    abstract double getSIUnitValue();
//    abstract Measurement<T> create(double value, T   t);
//    abstract T SIUnit();
//
//    public Measurement<T> add(Measurement<T> anotherMeasurement)  {
//        double value = this.getSIUnitValue() + anotherMeasurement.getSIUnitValue();
//        return create(value, this.SIUnit());
//    }
//
//    public boolean isValueWithinDelta(Measurement<T> anotherMeasurement, double delta) {
//        return  Math.abs(this.value - anotherMeasurement.value) <= delta;
//    }
//}
