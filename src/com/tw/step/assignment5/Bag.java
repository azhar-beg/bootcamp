package com.tw.step.assignment5;

import com.tw.step.assignment5.exception.InvalidCapacityException;
import com.tw.step.assignment5.exception.MaximumBagCapacityExceeded;
import com.tw.step.assignment5.exception.MaximumGreenBallsExceededException;

import java.util.HashSet;

public class Bag {
    private final int maxCapacity;
    private  final HashSet<Ball> balls;

    private Bag(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.balls = new HashSet<>();
    }

    boolean addBall(Ball ball) throws MaximumGreenBallsExceededException, MaximumBagCapacityExceeded {
        if (this.balls.size() >= this.maxCapacity){
            throw new MaximumBagCapacityExceeded(this.balls.size());
        }
        if (ball.getColor() == BallColor.GREEN){
            validateBall(ball);
        }

        return this.balls.add(ball);
    }

    private void validateBall(Ball ball) throws MaximumGreenBallsExceededException {
        long greenBallsCount = this.balls.stream()
                .filter(ball1 -> ball1.getColor() == BallColor.GREEN)
                .count();

         if(greenBallsCount >= 3){
             throw new MaximumGreenBallsExceededException();
         }
    }

    public static Bag create(int maxCapacity) throws InvalidCapacityException {
        if (maxCapacity > 12 || maxCapacity < 1){
            throw new InvalidCapacityException(maxCapacity);
        }
        return new Bag(maxCapacity);
    }
}
