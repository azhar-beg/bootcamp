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
    void shouldCreateAChanceForComplement() throws InvalidProbabilityException {
        Chance chance1 = Chance.createChance(0.9);
        Chance complementChance = chance1.complement();
        Chance chance2 = Chance.createChance(0.1);

        assertTrue(complementChance.approxEquals(chance2));
    }

    @Test
    void shouldCreateAChanceForIntersection() throws InvalidProbabilityException {
        Chance chance1 = Chance.createChance(0.3);
        Chance chance2 = Chance.createChance(0.3);
        Chance actual = chance2.intersection(chance1);
        Chance expected = Chance.createChance(0.09);

        assertTrue(actual.approxEquals(expected));
    }

    @Test
    void shouldThrowErrorForNegativeProbability()  {
        assertThrows(InvalidProbabilityException.class, () -> Chance.createChance(-2));
    }

    @Test
    void shouldThrowErrorForProbabilityGreaterThanOne()  {
        assertThrows(InvalidProbabilityException.class, () -> Chance.createChance(2));
    }
}