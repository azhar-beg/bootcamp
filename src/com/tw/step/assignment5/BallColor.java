package com.tw.step.assignment5;

import com.tw.step.assignment5.exception.BallNotAllowedException;
import com.tw.step.assignment5.exception.MaximumBallsExceededInBagException;

import java.util.HashSet;

public enum BallColor {
    GREEN {
        @Override
        public void validate(HashSet<Ball> balls) throws MaximumBallsExceededInBagException {
            long greenBallsCount = getBallsCount(balls, BallColor.GREEN);

            if (greenBallsCount >= 3) {
                throw new MaximumBallsExceededInBagException(BallColor.GREEN);
            }
        }
    },

    RED {
        @Override
        public void validate(HashSet<Ball> balls) throws MaximumBallsExceededInBagException {
            long greenBallsCount = getBallsCount(balls, BallColor.GREEN);
            long redBallsCount = getBallsCount(balls, BallColor.RED);

            if ((greenBallsCount * 2) <= redBallsCount) {
                throw new MaximumBallsExceededInBagException(BallColor.RED);
            }
        }
    },

    YELLOW {
        @Override
        public void validate(HashSet<Ball> balls) throws MaximumBallsExceededInBagException {
            long yellowBallsCount = getBallsCount(balls,BallColor.YELLOW);
            double yellowBallsPercentage = getYellowBallsPercentage(balls,yellowBallsCount);

            if (yellowBallsPercentage > 40){
                throw new MaximumBallsExceededInBagException(BallColor.YELLOW);
            }
        }

        private double getYellowBallsPercentage(HashSet<Ball> balls, long yellowBallsCount) {
            return (double) ((yellowBallsCount + 1) * 100) / (balls.size() + 1);
        }
    },

    BLUE {
        @Override
        public void validate(HashSet<Ball> balls) throws  BallNotAllowedException {
            long blackBallsCount = getBallsCount(balls,BallColor.BLACK);

            if (blackBallsCount > 0){
                throw new BallNotAllowedException(BallColor.BLUE);
            }
        }
    },

    BLACK {
        @Override
        public void validate(HashSet<Ball> balls) throws BallNotAllowedException {
            long blueBallsCount = getBallsCount(balls,BallColor.BLUE);

            if (blueBallsCount > 0){
                throw new BallNotAllowedException(BallColor.BLACK);
            }
        }
    };

    public void validate(HashSet<Ball> balls) throws MaximumBallsExceededInBagException, BallNotAllowedException {
    }

    private static long getBallsCount(HashSet<Ball> balls, BallColor color) {
        return balls.stream()
                .filter(ball1 -> ball1.getColor() == color)
                .count();
    }
}
