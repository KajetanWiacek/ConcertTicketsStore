package com.kajetanwiacek.concerttickets.ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class TicketTypeInfo {
    private Integer amount;
    private Double price;

    public void bookOneTicket(){
        amount--;
    }
}
