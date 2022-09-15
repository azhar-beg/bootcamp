package com.tw.step.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {

    @Test
    void shouldReturn1WhenFeetIsGreaterThanInches() {
        Length feet = new Length(1, Unit.FEET);
        Length inches = new Length(1, Unit.INCHES);

        assertEquals(1, feet.compare(inches));
    }

    @Test
    void shouldReturn0WhenBothLengthsAreEqual() {
        Length feet = new Length(1, Unit.FEET);
        Length inches = new Length(12, Unit.INCHES);

        assertEquals(0, feet.compare(inches));
    }

    @Test
    void shouldReturnNegativeWhenFeetIsSmallerThanInches() {
        Length feet = new Length(1, Unit.FEET);
        Length inches = new Length(13, Unit.INCHES);

        assertEquals(-1, feet.compare(inches));
    }
}