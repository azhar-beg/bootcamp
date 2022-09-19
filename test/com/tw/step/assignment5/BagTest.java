package com.tw.step.assignment5;

import com.tw.step.assignment5.exception.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void shouldThrowExceptionOnInvalidCapacity() {
        assertThrows(InvalidCapacityException.class, () -> Bag.create(-1));
    }

    @Test
    void shouldPlaceGreenBallInBag() throws InvalidCapacityException,
            MaximumBagCapacityExceeded,
            MaximumBallsExceededInBagException,
            BallNotAllowedException {

        Bag bag = Bag.create(12);
        Ball greenBall = new Ball(BallColor.GREEN);

        assertTrue(bag.addBall(greenBall));
    }

    @Test
    void shouldPlaceThreeGreenBalls() throws InvalidCapacityException,
            MaximumBagCapacityExceeded,
            MaximumBallsExceededInBagException,
            BallNotAllowedException {

        Bag bag = Bag.create(12);
        Ball greenBall1 = new Ball(BallColor.GREEN);
        Ball greenBall2 = new Ball(BallColor.GREEN);
        Ball greenBall3 = new Ball(BallColor.GREEN);

        bag.addBall(greenBall1);
        bag.addBall(greenBall2);

        assertTrue(bag.addBall(greenBall3));
    }

    @Test
    void shouldPlaceRedBallInBag() throws InvalidCapacityException,
            MaximumBagCapacityExceeded, MaximumBallsExceededInBagException,
            BallNotAllowedException {

        Bag bag = Bag.create(12);
        Ball greenBall = new Ball(BallColor.GREEN);
        Ball redBall = new Ball(BallColor.RED);

        bag.addBall(greenBall);

        assertTrue(bag.addBall(redBall));
    }

    @Test
    void shouldThrowExceptionWhileAddingFourthGreenBall() throws InvalidCapacityException,
            MaximumBagCapacityExceeded,
            MaximumBallsExceededInBagException,
            BallNotAllowedException {

        Bag bag = Bag.create(12);
        Ball greenBall1 = new Ball(BallColor.GREEN);
        Ball greenBall2 = new Ball(BallColor.GREEN);
        Ball greenBall3 = new Ball(BallColor.GREEN);
        Ball greenBall4 = new Ball(BallColor.GREEN);

        bag.addBall(greenBall1);
        bag.addBall(greenBall2);
        bag.addBall(greenBall3);

        assertThrows(MaximumBallsExceededInBagException.class, () -> bag.addBall(greenBall4));
    }

    @Test
    void shouldThrowMaximumBagCapacityException() throws InvalidCapacityException,
            MaximumBagCapacityExceeded,
            MaximumBallsExceededInBagException,
            BallNotAllowedException {

        Bag bag = Bag.create(2);
        Ball greenBall1 = new Ball(BallColor.GREEN);
        Ball greenBall2 = new Ball(BallColor.GREEN);
        Ball greenBall3 = new Ball(BallColor.GREEN);

        bag.addBall(greenBall1);
        bag.addBall(greenBall2);

        assertThrows(MaximumBagCapacityExceeded.class, () -> bag.addBall(greenBall3));
    }

    @Test
    void shouldThrowExceptionWhileAddingExtraRedBall() throws InvalidCapacityException {
        Bag bag = Bag.create(1);
        Ball redBall1 = new Ball(BallColor.RED);

        assertThrows(MaximumBallsExceededInBagException.class, () -> bag.addBall(redBall1));
    }

    @Test
    void shouldThrowExceptionForMoreThan40PercentOfYellowBalls() throws InvalidCapacityException {
        Bag bag = Bag.create(1);
        Ball yellowBall = new Ball(BallColor.YELLOW);

        assertThrows(MaximumBallsExceededInBagException.class, () -> bag.addBall(yellowBall));
    }


    @Test
    void shouldAddYellowBall() throws InvalidCapacityException,
            MaximumBagCapacityExceeded,
            MaximumBallsExceededInBagException,
            BallNotAllowedException {

        Bag bag = Bag.create(4);
        Ball yellowBall = new Ball(BallColor.YELLOW);
        Ball greenBall1 = new Ball(BallColor.GREEN);
        Ball greenBall2 = new Ball(BallColor.GREEN);

        bag.addBall(greenBall1);
        bag.addBall(greenBall2);

        assertTrue(bag.addBall(yellowBall));
    }

    @Test
    void shouldAddBlackBall() throws InvalidCapacityException,
            MaximumBagCapacityExceeded,
            MaximumBallsExceededInBagException,
            BallNotAllowedException {

        Bag bag = Bag.create(4);
        Ball blackBall = new Ball(BallColor.BLACK);

        assertTrue(bag.addBall(blackBall));
    }

    @Test
    void shouldThrowExceptionWhileAddingBlackBallWhenBlueBallIsPresent() throws InvalidCapacityException,
            MaximumBagCapacityExceeded,
            MaximumBallsExceededInBagException,
            BallNotAllowedException {

        Bag bag = Bag.create(4);
        Ball blackBall = new Ball(BallColor.BLACK);
        Ball blueBall = new Ball(BallColor.BLUE);

        bag.addBall(blueBall);

        assertThrows(BallNotAllowedException.class,()->bag.addBall(blackBall));
    }

     @Test
    void shouldThrowExceptionWhileAddingBlueBallWhenBlackBallIsPresent() throws InvalidCapacityException,
             MaximumBagCapacityExceeded,
             MaximumBallsExceededInBagException,
             BallNotAllowedException {

        Bag bag = Bag.create(4);
        Ball blackBall = new Ball(BallColor.BLACK);
        Ball blueBall = new Ball(BallColor.BLUE);

        bag.addBall(blackBall);

         assertThrows(BallNotAllowedException.class,()->bag.addBall(blueBall));
    }

}