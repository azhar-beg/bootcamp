package com.tw.step.assignment5;

import com.tw.step.assignment5.exception.InvalidCapacityException;
import com.tw.step.assignment5.exception.MaximumBagCapacityExceeded;
import com.tw.step.assignment5.exception.MaximumBallsExceededInBagException;

import java.util.HashSet;

public class Bag {
    private final int maxCapacity;
    private  final HashSet<Ball> balls;

    private Bag(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.balls = new HashSet<>();
    }

    boolean addBall(Ball ball) throws MaximumBagCapacityExceeded, MaximumBallsExceededInBagException {
        validateBall(ball);

        return this.balls.add(ball);
    }

    private void validateBall(Ball ball) throws MaximumBagCapacityExceeded, MaximumBallsExceededInBagException {
        if (this.balls.size() >= this.maxCapacity){
            throw new MaximumBagCapacityExceeded(this.balls.size());
        }

        if (ball.getColor() == BallColor.GREEN){
            validateGreenBalls();
        }

        if (ball.getColor() == BallColor.RED){
            validateRedBalls();
        }

        if (ball.getColor() == BallColor.YELLOW){
            validateYellowBalls();
        }
    }

    private void validateYellowBalls() throws MaximumBallsExceededInBagException {
        long yellowBallsCount = getBallsCount(BallColor.YELLOW);
        double yellowBallsPercentage = getYellowBallsPercentage(yellowBallsCount);

        if (yellowBallsPercentage > 40){
            throw new MaximumBallsExceededInBagException(BallColor.YELLOW);
        }
    }

    private double getYellowBallsPercentage(long yellowBallsCount) {
        return (double) ((yellowBallsCount + 1) * 100) / (this.balls.size() + 1);
    }

    private void validateRedBalls() throws MaximumBallsExceededInBagException {
        long greenBallsCount = getBallsCount(BallColor.GREEN);
        long redBallsCount = getBallsCount(BallColor.RED);

        if((greenBallsCount * 2) <= redBallsCount){
            throw new MaximumBallsExceededInBagException(BallColor.RED);
        }
    }

    private void validateGreenBalls() throws MaximumBallsExceededInBagException {
        long greenBallsCount = getBallsCount(BallColor.GREEN);

        if(greenBallsCount >= 3){
            throw new MaximumBallsExceededInBagException(BallColor.GREEN);
        }
    }

    private long getBallsCount(BallColor color) {
        return this.balls.stream()
                .filter(ball1 -> ball1.getColor() == color)
                .count();
    }

    public static Bag create(int maxCapacity) throws InvalidCapacityException {
        if (maxCapacity > 12 || maxCapacity < 1){
            throw new InvalidCapacityException(maxCapacity);
        }
        return new Bag(maxCapacity);
    }
}
