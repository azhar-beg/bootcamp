package com.tw.step.assignment5.exception;

import com.tw.step.assignment5.BallColor;

public class BallNotAllowedException extends Throwable {
    public BallNotAllowedException(BallColor color) {
        super("Ball not allowed" + color);
    }
}
