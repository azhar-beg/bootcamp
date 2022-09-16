package com.tw.step.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest {

    @Test
    void shouldCompareGreaterGallonWithLesserLitre() {
        Volume gallon = Volume.create(1, VolumeUnit.GALLON);
        Volume litre = Volume.create(1, VolumeUnit.LITRE);

        assertEquals(ComparisonResult.GREATER, gallon.compare(litre));
    }

    @Test
    void shouldAddGallonAndLitre() {
        Volume gallon = Volume.create(1, VolumeUnit.GALLON);
        Volume litre = Volume.create(1, VolumeUnit.LITRE);

        Volume actual = gallon.add(litre);
        Volume expected = Volume.create(4.78, VolumeUnit.LITRE);
        assertTrue(actual.isValueWithinDelta(expected, 0.01));
    }
}