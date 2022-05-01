package com.kajetanwiacek.concerttickets.exception;

import com.kajetanwiacek.concerttickets.ticket.TicketType;

public class NoTicketsLeftException extends RuntimeException{
    public NoTicketsLeftException(TicketType type) {
        super("No tickets available for type "+type);
    }
}
