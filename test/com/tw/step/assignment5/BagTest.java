package com.tw.step.assignment5;

import com.tw.step.assignment5.exception.InvalidCapacityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void shouldThrowExceptionOnInvalidCapacity() {
        assertThrows(InvalidCapacityException.class,()->Bag.create(-1));
    }

}