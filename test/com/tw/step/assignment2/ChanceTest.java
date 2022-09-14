package com.tw.step.assignment2;

import com.tw.step.assignment2.exception.InvalidProbabilityException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

    @Test
    void getting() throws InvalidProbabilityException {
        Chance chance = Chance.createChance(0.5);
        assertEquals(0.5, chance.probability());
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
        Chance compliment = Chance.compliment(0.1);

        assertEquals(0.9, compliment.probability());
    }

    @Test
    void shouldThrowErrorForInvalidCompliment() throws InvalidProbabilityException {
        assertThrows(InvalidProbabilityException.class, () -> Chance.compliment(-1));
    }
}