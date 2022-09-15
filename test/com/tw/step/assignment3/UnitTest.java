package com.tw.step.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    @Test
    void shouldConvertFeetToCm() {
        assertEquals(30, LengthUnit.FEET.toCM(1));
    }

    @Test
    void shouldConvertInchToCm() {
        assertEquals(5, LengthUnit.INCH.toCM(2));
    }
}