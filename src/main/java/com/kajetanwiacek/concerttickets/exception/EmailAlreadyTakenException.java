package com.kajetanwiacek.concerttickets.exception;

public class EmailAlreadyTakenException extends RuntimeException{
    public EmailAlreadyTakenException(String email) {
        super(email+" already taken");
    }
}
