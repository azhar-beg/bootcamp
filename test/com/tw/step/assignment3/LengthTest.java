package com.tw.step.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {

    @Test
    void shouldReturn1WhenFeetIsGreaterThanInches() {
        Length feet = new Length(1, Unit.FEET);
        Length inches = new Length(1, Unit.INCH);

        assertEquals(1, feet.compare(inches));
    }

    @Test
    void shouldReturn0WhenBothLengthsAreEqual() {
        Length feet = new Length(1, Unit.FEET);
        Length inches = new Length(12, Unit.INCH);

        assertEquals(0, feet.compare(inches));
    }

    @Test
    void shouldReturnNegativeWhenFeetIsLessThanInches() {
        Length feet = new Length(1, Unit.FEET);
        Length inches = new Length(13, Unit.INCH);

        assertEquals(-1, feet.compare(inches));
    }

    @Test
    void shouldReturn1WhenInchesIsGreaterThanCentimeters() {
        Length inch = new Length(1, Unit.INCH);
        Length cm = new Length(1, Unit.CM);

        assertEquals(1, inch.compare(cm));
    }

    @Test
    void shouldReturn1WhenCMIsGreaterThanMM() {
        Length cm = new Length(1, Unit.CM);
        Length mm = new Length(5, Unit.MM);

        assertEquals(1, cm.compare(mm));
    }
}