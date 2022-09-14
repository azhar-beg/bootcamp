package com.tw.step.assignment2;

import com.tw.step.assignment2.exception.InvalidProbabilityException;

import java.util.Objects;

public class Chance {
    protected final double probability;

    private Chance(double probability) {
        this.probability = probability;
    }

    public static Chance createChance(double probability) throws InvalidProbabilityException {
        if (probability < 0 || probability > 1) {
            throw new InvalidProbabilityException(probability);
        }
        return new Chance(probability);
    }

    public static Chance complement(double probability) throws InvalidProbabilityException {
        return createChance(1 - probability);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chance chance = (Chance) o;
        return Double.compare(chance.probability, probability) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(probability);
    }
}
