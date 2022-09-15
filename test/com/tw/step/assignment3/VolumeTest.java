package com.tw.step.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest {

    @Test
    void shouldReturn1WhenGallonIsGreaterThanLitre() {
        Volume gallon = new Volume(1, VolumeUnit.GALLON);
        Volume litre = new Volume(1, VolumeUnit.LITRE);

        assertEquals(1, gallon.compare(litre));
    }
}