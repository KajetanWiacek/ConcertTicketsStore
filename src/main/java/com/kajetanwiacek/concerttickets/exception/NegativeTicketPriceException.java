package com.kajetanwiacek.concerttickets.exception;

import com.kajetanwiacek.concerttickets.ticket.TicketType;

public class NegativeTicketPriceException extends RuntimeException{
    public NegativeTicketPriceException(TicketType type) {
        super("Ticket type "+type+" has a negative price");
    }
}
