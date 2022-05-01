package com.kajetanwiacek.concerttickets.exception;

public class ConcertNotFoundException extends RuntimeException{
    public ConcertNotFoundException(Long id) {
        super("No concert with id "+id+" was found");
    }
}
