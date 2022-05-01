package com.kajetanwiacek.concerttickets.order;

import com.kajetanwiacek.concerttickets.concert.ConcertService;
import com.kajetanwiacek.concerttickets.user.User;
import com.kajetanwiacek.concerttickets.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    UserService userService;
    OrderService orderService;
    ConcertService concertService;

    @Autowired
    public OrderController(UserService userService, OrderService orderService,ConcertService concertService) {
        this.userService = userService;
        this.orderService = orderService;
        this.concertService = concertService;
    }

    @PostMapping
    public void addOrder(Principal principal, @RequestBody List<OrderItems> itemsList){
        User user = userService.getUser(principal.getName());
        orderService.saveOrder(user,itemsList);
    }

    @GetMapping
    public List<OrderInfo> getUserOrders(Principal principal){
        User user = userService.getUser(principal.getName());
        return orderService.getUserOrders(user);
    }

    @GetMapping("/all")
    public List<OrderInfo> getOrders(){
        return orderService.getAllOrders();
    }

}
