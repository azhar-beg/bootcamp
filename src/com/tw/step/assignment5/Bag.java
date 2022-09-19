package com.tw.step.assignment5;

import com.tw.step.assignment5.exception.BallNotAllowedException;
import com.tw.step.assignment5.exception.InvalidCapacityException;
import com.tw.step.assignment5.exception.MaximumBagCapacityExceededException;
import com.tw.step.assignment5.exception.MaximumBallsExceededInBagException;

import java.util.HashSet;

public class Bag {
    private final int maxCapacity;
    private  final HashSet<Ball> balls;

    private Bag(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.balls = new HashSet<>();
    }

    boolean addBall(Ball ball) throws MaximumBagCapacityExceededException,
            MaximumBallsExceededInBagException,
            BallNotAllowedException {

        validateBall(ball);
        return this.balls.add(ball);
    }

    private void validateBall(Ball ball) throws MaximumBagCapacityExceededException,
            MaximumBallsExceededInBagException,
            BallNotAllowedException {

        if (this.balls.size() >= this.maxCapacity){
            throw new MaximumBagCapacityExceededException(this.balls.size());
        }

        // Don't ask friends of friends.
        ball.getColor().validate(this.balls);
    }

    public static Bag create(int maxCapacity) throws InvalidCapacityException {

        if (maxCapacity > 12 || maxCapacity < 1){
            throw new InvalidCapacityException(maxCapacity);
        }

        return new Bag(maxCapacity);
    }
}
