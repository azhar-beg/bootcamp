package com.tw.step.assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

    @Test
    void getting() {
        Chance chance = Chance.createChance(0.5);
        assertEquals(0.5, chance.getting());
    }

    @Test
    void notGetting() {
        Chance chance = Chance.createChance(0.4);
        assertEquals(0.6, chance.notGetting());
    }
}