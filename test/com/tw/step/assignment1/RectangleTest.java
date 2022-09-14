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
    void calculateAreaForDecimalValues() {
        Rectangle rectangle = new Rectangle(4, 2.5);
        assertEquals(10, rectangle.area());
    }

    @Test
    void calculatePerimeter(){
        Rectangle rectangle = new Rectangle(3, 3);
        assertEquals(12, rectangle.perimeter());
    }

    @Test
    void calculatePerimeterForDecimalValues(){
        Rectangle rectangle = new Rectangle(4.5, 2.5);
        assertEquals(14, rectangle.perimeter());
    }
}