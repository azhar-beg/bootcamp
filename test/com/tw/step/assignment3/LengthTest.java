package com.tw.step.assignment3;

import com.tw.step.assignment3.exception.NegativeLengthException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {

    @Test
    void shouldReturn1WhenFeetIsGreaterThanInches() throws NegativeLengthException {
        Length feet = Length.create(1, LengthUnit.FEET);
        Length inches = Length.create(1, LengthUnit.INCH);

        assertEquals(1, feet.compare(inches));
    }

    @Test
    void shouldReturn0WhenBothLengthsAreEqual() throws NegativeLengthException {
        Length feet = Length.create(1, LengthUnit.FEET);
        Length inches = Length.create(12, LengthUnit.INCH);

        assertEquals(0, feet.compare(inches));
    }

    @Test
    void shouldReturnNegativeWhenFeetIsLessThanInches() throws NegativeLengthException {
        Length feet = Length.create(1, LengthUnit.FEET);
        Length inches = Length.create(13, LengthUnit.INCH);

        assertEquals(-1, feet.compare(inches));
    }

    @Test
    void shouldReturn1WhenInchesIsGreaterThanCentimeters() throws NegativeLengthException {
        Length inch = Length.create(1, LengthUnit.INCH);
        Length cm = Length.create(1, LengthUnit.CM);

        assertEquals(1, inch.compare(cm));
    }

    @Test
    void shouldReturn1WhenCMIsGreaterThanMM() throws NegativeLengthException {
        Length cm = Length.create(1, LengthUnit.CM);
        Length mm = Length.create(5, LengthUnit.MM);

        assertEquals(1, cm.compare(mm));
    }

    @Test

    void shouldAddTwoInches() throws NegativeLengthException {
        Length inch1 = Length.create(1, LengthUnit.INCH);
        Length inch2 = Length.create(2, LengthUnit.INCH);

        Length actual = inch1.add(inch2);
        Length expected = Length.create(3, LengthUnit.INCH);

        assertTrue(actual.isValueWithinDelta(expected, 0.01));
    }

    @Test
    void shouldThrowErrorForNegativeLength() {
        assertThrows(NegativeLengthException.class, ()-> Length.create(-1, LengthUnit.INCH));
    }
}