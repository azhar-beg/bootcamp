package com.tw.step.assignment2;

import com.tw.step.assignment2.exception.InvalidProbabilityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

    @Test
    void shouldCreateChanceOfGivenProbability() throws InvalidProbabilityException {
        Chance chance1 = Chance.createChance(0.5);
        Chance chance2 = Chance.createChance(0.5);

        assertTrue(chance1.equals(chance2));
    }

    @Test
    void shouldCreateAChanceForCompliment() throws InvalidProbabilityException {
        Chance complimentChance = Chance.complement(0.1);
        Chance chance = Chance.createChance(0.9);

        assertTrue(complimentChance.equals(chance));
    }

    @Test
    void shouldThrowErrorForNegativeProbability()  {
        assertThrows(InvalidProbabilityException.class, () -> Chance.createChance(-2));
    }

    @Test
    void shouldThrowErrorForProbabilityGreaterThanOne()  {
        assertThrows(InvalidProbabilityException.class, () -> Chance.createChance(2));
    }

    @Test
    void shouldThrowErrorForInvalidCompliment() {
        assertThrows(InvalidProbabilityException.class, () -> Chance.complement(-1));
    }
}