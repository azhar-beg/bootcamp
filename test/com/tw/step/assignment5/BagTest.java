package com.tw.step.assignment5;

import com.tw.step.assignment5.exception.InvalidCapacityException;
import com.tw.step.assignment5.exception.MaximumGreenBallsExceededException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void shouldThrowExceptionOnInvalidCapacity() {
        assertThrows(InvalidCapacityException.class,()->Bag.create(-1));
    }

    @Test
    void shouldPlaceABallInBag() throws InvalidCapacityException, MaximumGreenBallsExceededException {
        Bag bag = Bag.create(12);
        Ball greenBall = new Ball(BallColor.GREEN);

        assertTrue(bag.addBall(greenBall));
    }

    @Test
    void shouldPlaceThreeGreenBalls() throws InvalidCapacityException, MaximumGreenBallsExceededException {
        Bag bag = Bag.create(12);
        Ball greenBall1 = new Ball(BallColor.GREEN);
        Ball greenBall2 = new Ball(BallColor.GREEN);
        Ball greenBall3 = new Ball(BallColor.GREEN);

        bag.addBall(greenBall1);
        bag.addBall(greenBall2);

        assertTrue(bag.addBall(greenBall3));
    }

     @Test
    void shouldThrowExceptionWhileAddingFourthGreenBall() throws InvalidCapacityException, MaximumGreenBallsExceededException {
        Bag bag = Bag.create(12);
        Ball greenBall1 = new Ball(BallColor.GREEN);
        Ball greenBall2 = new Ball(BallColor.GREEN);
        Ball greenBall3 = new Ball(BallColor.GREEN);
        Ball greenBall4 = new Ball(BallColor.GREEN);

        bag.addBall(greenBall1);
        bag.addBall(greenBall2);
        bag.addBall(greenBall3);

        assertThrows(MaximumGreenBallsExceededException.class, ()-> bag.addBall(greenBall4));
    }


}