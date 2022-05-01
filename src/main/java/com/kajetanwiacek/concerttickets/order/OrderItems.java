package com.kajetanwiacek.concerttickets.order;
import com.kajetanwiacek.concerttickets.ticket.TicketType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Embeddable
public class OrderItems {
    private Long concertId;
    private TicketType type;
    private Integer amount;
}
