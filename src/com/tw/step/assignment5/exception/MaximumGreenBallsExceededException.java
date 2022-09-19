package com.tw.step.assignment5.exception;

import com.tw.step.assignment5.Ball;

public class MaximumGreenBallsExceededException extends Throwable {
    public MaximumGreenBallsExceededException() {
        super("Maximum green balls size exceeded in bag");
    }
}
