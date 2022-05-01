package com.kajetanwiacek.concerttickets.exception;

public class PriceListIsEmptyException extends RuntimeException{
    public PriceListIsEmptyException() {
        super("There are no tickets available to buy");
    }
}
