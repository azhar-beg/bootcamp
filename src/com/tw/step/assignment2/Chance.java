package com.tw.step.assignment2;

public class Chance {
    private static double probability;

    private Chance(double probability) {
        this.probability = probability;
    }

    public static Chance createChance(double probability) {
        return new Chance(probability);
    }

    public double getting() {
        return probability;
    }

    public double notGetting() {
        return 1 - probability;
    }
}
