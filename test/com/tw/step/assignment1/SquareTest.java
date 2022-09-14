package com.tw.step.assignment1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void calculateArea() {
        Square square = new Square(2);
        assertEquals(4, square.area());
    }

    @Test
    void calculateAreaForDecimal() {
        Square square = new Square(2.5);
        assertEquals(6.25, square.area());
    }

    @Test
    void calculatePerimeter() {
        Square square = new Square(2);
        assertEquals(8, square.perimeter());
    }

    @Test
    void calculatePerimeterForDecimal() {
        Square square = new Square(2.5);
        assertEquals(10, square.perimeter());
    }
}