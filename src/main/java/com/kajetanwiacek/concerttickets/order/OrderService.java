package com.kajetanwiacek.concerttickets.order;

import com.kajetanwiacek.concerttickets.concert.Concert;
import com.kajetanwiacek.concerttickets.concert.ConcertService;
import com.kajetanwiacek.concerttickets.exception.AmountMustBeGreaterThanZeroException;
import com.kajetanwiacek.concerttickets.exception.NotEnoughTicketsAvailableException;
import com.kajetanwiacek.concerttickets.ticket.Ticket;
import com.kajetanwiacek.concerttickets.ticket.TicketService;
import com.kajetanwiacek.concerttickets.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ConcertService concertService;

    @Autowired
    public OrderService(OrderRepository orderRepository, ConcertService concertService) {
        this.orderRepository = orderRepository;
        this.concertService = concertService;
    }

    public void saveOrder(User user, List<OrderItems> itemsList) {
        List<Ticket> ticketList = new ArrayList<>();
        double cost = 0.0;

        for (OrderItems tickets : itemsList) {

            int amount = tickets.getAmount();
            Concert concert = concertService.getConcert(tickets.getConcertId());

            if(amount<=0){
                throw new AmountMustBeGreaterThanZeroException();
            }

            concertService.isTypeAvailable(concert,tickets.getType());

            int availableAmount = concert.getPriceList().getTicketsInfo().get(tickets.getType()).getAmount();
            if(amount>availableAmount){
                throw new NotEnoughTicketsAvailableException(concert.getName());
            }

            while (amount > 0) {
                Ticket ticket = TicketService.create(concert, tickets.getType());

                cost += ticket.getPrice();
                ticketList.add(ticket);
                user.getTicketList().add(ticket);

                amount--;
            }
        }

        orderRepository.save(new OrderInfo(user, ticketList, cost));
    }

        public List<OrderInfo> getAllOrders () {
            return orderRepository.findAll();
        }

        public List<OrderInfo> getUserOrders (User user){
            return orderRepository.getByUser(user);
        }
    }
