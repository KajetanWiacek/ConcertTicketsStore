package com.kajetanwiacek.concerttickets.exception;

public class NotEnoughTicketsAvailableException extends RuntimeException{
    public NotEnoughTicketsAvailableException(String name) {
        super("Not enough tickets available for "+name+" concert");
    }
}
