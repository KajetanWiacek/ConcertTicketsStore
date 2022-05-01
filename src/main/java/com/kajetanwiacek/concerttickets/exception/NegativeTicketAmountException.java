package com.kajetanwiacek.concerttickets.exception;

import com.kajetanwiacek.concerttickets.ticket.TicketType;

public class NegativeTicketAmountException extends RuntimeException{
    public NegativeTicketAmountException(TicketType type) {
        super("Ticket type "+type+" has a negative amount");
    }
}
