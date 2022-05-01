package com.kajetanwiacek.concerttickets.ticket;
import com.kajetanwiacek.concerttickets.concert.Concert;
import com.kajetanwiacek.concerttickets.concert.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final ConcertService concertService;

    @Autowired
    public TicketService(TicketRepository ticketRepository,ConcertService concertService) {
        this.ticketRepository = ticketRepository;
        this.concertService = concertService;
    }

    public static Ticket create(Concert concert,TicketType type){

        concert.getPriceList().buyTicket(type);

        Double price = concert.getPriceList().getTicketsInfo().get(type).getPrice();
        return new Ticket(concert,type,price);
    }
}
