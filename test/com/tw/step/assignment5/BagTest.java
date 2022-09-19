package com.tw.step.assignment5;

import com.tw.step.assignment5.exception.InvalidCapacityException;
import com.tw.step.assignment5.exception.MaximumBagCapacityExceeded;
import com.tw.step.assignment5.exception.MaximumBallsExceededInBagException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void shouldThrowExceptionOnInvalidCapacity() {
        assertThrows(InvalidCapacityException.class,()->Bag.create(-1));
    }

    @Test
    void shouldPlaceABallInBag() throws InvalidCapacityException, MaximumGreenBallsExceededException, MaximumBagCapacityExceeded, MaximumBallsExceededInBagException {
        Bag bag = Bag.create(12);
        Ball greenBall = new Ball(BallColor.GREEN);

        assertTrue(bag.addBall(greenBall));
    }

    @Test
    void shouldPlaceThreeGreenBalls() throws InvalidCapacityException, MaximumGreenBallsExceededException, MaximumBagCapacityExceeded, MaximumBallsExceededInBagException {
        Bag bag = Bag.create(12);
        Ball greenBall1 = new Ball(BallColor.GREEN);
        Ball greenBall2 = new Ball(BallColor.GREEN);
        Ball greenBall3 = new Ball(BallColor.GREEN);

        bag.addBall(greenBall1);
        bag.addBall(greenBall2);

        assertTrue(bag.addBall(greenBall3));
    }

     @Test
    void shouldThrowExceptionWhileAddingFourthGreenBall() throws InvalidCapacityException, MaximumGreenBallsExceededException, MaximumBagCapacityExceeded, MaximumBallsExceededInBagException {
        Bag bag = Bag.create(12);
        Ball greenBall1 = new Ball(BallColor.GREEN);
        Ball greenBall2 = new Ball(BallColor.GREEN);
        Ball greenBall3 = new Ball(BallColor.GREEN);
        Ball greenBall4 = new Ball(BallColor.GREEN);

        bag.addBall(greenBall1);
        bag.addBall(greenBall2);
        bag.addBall(greenBall3);

        assertThrows(MaximumBallsExceededInBagException.class, ()-> bag.addBall(greenBall4));
    }

    @Test
    void shouldThrowMaximumBagCapacityException() throws InvalidCapacityException, MaximumGreenBallsExceededException, MaximumBagCapacityExceeded, MaximumBallsExceededInBagException {
        Bag bag = Bag.create(2);
        Ball greenBall1 = new Ball(BallColor.GREEN);
        Ball greenBall2 = new Ball(BallColor.GREEN);
        Ball greenBall3 = new Ball(BallColor.GREEN);

        bag.addBall(greenBall1);
        bag.addBall(greenBall2);

        assertThrows(MaximumBagCapacityExceeded.class, ()-> bag.addBall(greenBall3));
    }

    @Test
    void shouldThrowExceptionWhileAddingExtraRedBall() throws InvalidCapacityException{
        Bag bag = Bag.create(1);
        Ball redball1 = new Ball(BallColor.RED);

        assertThrows(MaximumBallsExceededInBagException.class, ()-> bag.addBall(redball1));
    }



}