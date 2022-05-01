package com.kajetanwiacek.concerttickets.exception;

public class AmountMustBeGreaterThanZeroException extends RuntimeException{
    public AmountMustBeGreaterThanZeroException() {
        super("Amount must be greater than zero");
    }
}
