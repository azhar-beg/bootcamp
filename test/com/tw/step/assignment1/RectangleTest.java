package com.tw.step.assignment1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class RectangleTest {

    @Test
    void area() {

        Rectangle rectangle = new Rectangle(3, 3);
        assertEquals(9, rectangle.area());
    }
}