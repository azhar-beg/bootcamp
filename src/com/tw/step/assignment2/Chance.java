package com.tw.step.assignment2;

import com.tw.step.assignment2.exception.InvalidProbabilityException;

import java.util.Objects;

public class Chance {
    private final double probability;

    private Chance(double probability) {
        this.probability = probability;
    }

    public static Chance createChance(double probability) throws InvalidProbabilityException {
        if (probability < 0 || probability > 1) {
            throw new InvalidProbabilityException(probability);
        }
        return new Chance(probability);
    }

    public Chance complement() throws InvalidProbabilityException {
        return createChance(1.0 - this.probability);
    }

    public boolean approxEquals(Chance anotherChance) {
        if (this == anotherChance) return true;

        double delta = this.probability - anotherChance.probability;
        return delta < 0.001 || delta > -0.001;
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
