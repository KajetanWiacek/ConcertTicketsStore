package com.kajetanwiacek.concerttickets.order;

import com.kajetanwiacek.concerttickets.ticket.Ticket;
import com.kajetanwiacek.concerttickets.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Ticket> ticketList;

    private Double cost;

    public OrderInfo(User user, List<Ticket> ticketList, Double cost) {
        this.user = user;
        this.ticketList = ticketList;
        this.cost = cost;
    }
}
