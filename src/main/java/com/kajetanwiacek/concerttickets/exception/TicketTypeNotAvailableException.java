package com.kajetanwiacek.concerttickets.exception;

import com.kajetanwiacek.concerttickets.ticket.TicketType;

public class TicketTypeNotAvailableException extends RuntimeException{
    public TicketTypeNotAvailableException(TicketType type) {
        super("Ticket type "+type+ " is not available for this concert");
    }
}
