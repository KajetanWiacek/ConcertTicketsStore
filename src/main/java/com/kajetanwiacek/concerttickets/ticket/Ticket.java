package com.kajetanwiacek.concerttickets.ticket;

import com.kajetanwiacek.concerttickets.concert.Concert;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Concert concert;

    private TicketType type;

    private Double price;

    public Ticket(Concert concert, TicketType type, Double price) {
        this.concert = concert;
        this.type = type;
        this.price = price;
    }
}
