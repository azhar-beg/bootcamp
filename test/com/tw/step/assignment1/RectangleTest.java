package com.tw.step.assignment1;

import com.tw.step.assignment1.exception.InvalidSideException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
class RectangleTest {

    @Test
    void calculateArea() throws InvalidSideException {
        Rectangle rectangle = Rectangle.createRectangle(3, 3);
        assertEquals(9, rectangle.area());
    }

    @Test
    void calculateAreaForDecimalValues() throws InvalidSideException {
        Rectangle rectangle = Rectangle.createRectangle(4, 2.5);
        assertEquals(10, rectangle.area());
    }

    @Test
    void calculatePerimeter() throws InvalidSideException {
        Rectangle rectangle = Rectangle.createRectangle(3, 3);
        assertEquals(12, rectangle.perimeter());
    }

    @Test
    void calculatePerimeterForDecimalValues() throws InvalidSideException {
        Rectangle rectangle = Rectangle.createRectangle(4.5, 2.5);
        assertEquals(14, rectangle.perimeter());
    }

    @Test
    void createSquare() throws InvalidSideException {
        Rectangle rectangle = Rectangle.createSquare(4);
        assertEquals(16, rectangle.area());
    }

    @Test
    void shouldThrowErrorForNegativeSides(){

        assertThrows(InvalidSideException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Rectangle.createRectangle(-1, 1);
            }
        });
    }

    @Test
    void shouldThrowErrorForNegativeSidesForSquare(){

        assertThrows(InvalidSideException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Rectangle.createSquare(-1);
            }
        });
    }
}