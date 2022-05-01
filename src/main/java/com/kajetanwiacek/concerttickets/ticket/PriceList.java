package com.kajetanwiacek.concerttickets.ticket;

import com.kajetanwiacek.concerttickets.exception.NoTicketsLeftException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@AllArgsConstructor
@Getter
public class PriceList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ElementCollection
    private Map<TicketType, TicketTypeInfo> ticketsInfo;

    public PriceList() {
        this.ticketsInfo = new HashMap<>();
    }

    public void buyTicket(TicketType type){
        TicketTypeInfo typeInfo = ticketsInfo.get(type);
        if(typeInfo.getAmount()==0){
            throw new NoTicketsLeftException(type);
        }
        typeInfo.bookOneTicket();
    }
}
