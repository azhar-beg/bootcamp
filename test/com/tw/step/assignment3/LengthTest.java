package com.tw.step.assignment3;

import com.tw.step.assignment3.exception.NegativeLengthException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {

    @Test
    void shouldReturn1WhenFeetIsGreaterThanInches() throws NegativeLengthException {
        Length feet = Length.create(1, Unit.FEET);
        Length inches = Length.create(1, Unit.INCH);

        assertEquals(1, feet.compare(inches));
    }

    @Test
    void shouldReturn0WhenBothLengthsAreEqual() throws NegativeLengthException {
        Length feet = Length.create(1, Unit.FEET);
        Length inches = Length.create(12, Unit.INCH);

        assertEquals(0, feet.compare(inches));
    }

    @Test
    void shouldReturnNegativeWhenFeetIsLessThanInches() throws NegativeLengthException {
        Length feet = Length.create(1, Unit.FEET);
        Length inches = Length.create(13, Unit.INCH);

        assertEquals(-1, feet.compare(inches));
    }

    @Test
    void shouldReturn1WhenInchesIsGreaterThanCentimeters() throws NegativeLengthException {
        Length inch = Length.create(1, Unit.INCH);
        Length cm = Length.create(1, Unit.CM);

        assertEquals(1, inch.compare(cm));
    }

    @Test
    void shouldReturn1WhenCMIsGreaterThanMM() throws NegativeLengthException {
        Length cm = Length.create(1, Unit.CM);
        Length mm = Length.create(5, Unit.MM);

        assertEquals(1, cm.compare(mm));
    }

    @Test
    void shouldThrowErrorForNegativeLength() {
        assertThrows(NegativeLengthException.class, ()-> Length.create(-1, Unit.INCH));
    }
}