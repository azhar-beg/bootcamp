package com.tw.step.assignment1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class RectangleTest {

    @Test
    void calculateArea() {

        Rectangle rectangle = new Rectangle(3, 3);
        assertEquals(9, rectangle.area());
    }

    @Test
    void perimeter(){
        Rectangle rectangle = new Rectangle(3, 3);
        assertEquals(12, rectangle.perimeter());
    }
}