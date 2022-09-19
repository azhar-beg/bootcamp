package com.tw.step.assignment5.exception;

import com.tw.step.assignment5.BallColor;

public class MaximumBallsExceededInBagException extends Throwable {
    public MaximumBallsExceededInBagException(BallColor color) {
        super("Maximum Balls Exceeded in bag of" + color);
    }
}
