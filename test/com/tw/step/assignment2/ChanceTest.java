package com.tw.step.assignment2;

import com.tw.step.assignment2.exception.InvalidProbabilityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

    @Test
    void shouldCreateChanceOfGivenProbability() throws InvalidProbabilityException {
        Chance chance = Chance.createChance(0.5);

        assertEquals(0.5, chance.probability);
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
    void shouldCreateAChanceForCompliment() throws InvalidProbabilityException {
        Chance compliment = Chance.complement(0.1);

        assertEquals(0.9, compliment.probability);
    }

    @Test
    void shouldThrowErrorForInvalidCompliment() throws InvalidProbabilityException {
        assertThrows(InvalidProbabilityException.class, () -> Chance.complement(-1));
    }
}