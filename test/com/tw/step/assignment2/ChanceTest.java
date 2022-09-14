package com.tw.step.assignment2;

import com.tw.step.assignment2.exception.InvalidProbabilityException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

    @Test
    void getting() throws InvalidProbabilityException {
        Chance chance = Chance.createChance(0.5);
        assertEquals(0.5, chance.getting());
    }

    @Test
    void notGetting() throws InvalidProbabilityException {
        Chance chance = Chance.createChance(0.4);
        assertEquals(0.6, chance.notGetting());
    }

    @Test
    void shouldThrowErrorForInvalidProbability()  {
        assertThrows(InvalidProbabilityException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Chance.createChance(2);
            }
        });
    }
}