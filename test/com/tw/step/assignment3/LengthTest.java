package com.tw.step.assignment3;

import com.tw.step.assignment3.exception.NegativeLengthException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {

    @Test
    void shouldCompareGreaterFeetWithLesserInches() throws NegativeLengthException {
        Length feet = Length.create(1, LengthUnit.FEET);
        Length inches = Length.create(1, LengthUnit.INCH);

        assertEquals(ComparisonResult.GREATER, feet.compare(inches));
    }

    @Test
    void shouldCompareEqualFeetWithEqualInches() throws NegativeLengthException {
        Length feet = Length.create(1, LengthUnit.FEET);
        Length inches = Length.create(12, LengthUnit.INCH);

        assertEquals(ComparisonResult.EQUAL, feet.compare(inches));
    }

    @Test
    void shouldCompareLesserFeetWithGreaterInches() throws NegativeLengthException {
        Length feet = Length.create(1, LengthUnit.FEET);
        Length inches = Length.create(13, LengthUnit.INCH);

        assertEquals(ComparisonResult.LESS, feet.compare(inches));
    }

    @Test
    void shouldCompareGreaterInchWithLesserCM() throws NegativeLengthException {
        Length inch = Length.create(1, LengthUnit.INCH);
        Length cm = Length.create(1, LengthUnit.CM);

        assertEquals(ComparisonResult.GREATER, inch.compare(cm));
    }

    @Test
    void shouldCompareGreaterCMWithLesserMM() throws NegativeLengthException {
        Length cm = Length.create(1, LengthUnit.CM);
        Length mm = Length.create(5, LengthUnit.MM);

        assertEquals(ComparisonResult.GREATER, cm.compare(mm));
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
    void shouldAddInchAndCM() throws NegativeLengthException {
        Length cm = Length.create(2.5, LengthUnit.CM);
        Length inch = Length.create(2, LengthUnit.INCH);

        Length actual = cm.add(inch);
        Length expected = Length.create(3, LengthUnit.INCH);

        assertTrue(actual.isValueWithinDelta(expected, 0.01));
    }

    @Test
    void shouldThrowErrorForNegativeLength() {
        assertThrows(NegativeLengthException.class, ()-> Length.create(-1, LengthUnit.INCH));
    }
}