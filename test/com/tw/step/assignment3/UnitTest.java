package com.tw.step.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    @Test
    void shouldConvertFeetToCm() {
        assertEquals(30, Unit.FEET.toCM(1));
    }

    @Test
    void shouldConvertInchToCm() {
        assertEquals(5, Unit.INCH.toCM(2));
    }
}