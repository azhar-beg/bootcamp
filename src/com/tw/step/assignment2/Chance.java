package com.tw.step.assignment2;

import com.tw.step.assignment2.exception.InvalidProbabilityException;

public class Chance {
    private static double probability;

    private Chance(double probability) {
        this.probability = probability;
    }

    public static Chance createChance(double probability) throws InvalidProbabilityException {
        if (probability < 0 || probability > 1) {
            throw new InvalidProbabilityException(probability);
        }
        return new Chance(probability);
    }

    public double getting() {
        return probability;
    }

    public double notGetting() {
        return 1 - probability;
    }
}
