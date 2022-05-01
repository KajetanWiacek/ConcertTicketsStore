package com.kajetanwiacek.concerttickets.ticket;

import com.kajetanwiacek.concerttickets.user.User;
import com.kajetanwiacek.concerttickets.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    UserRepository userRepository;

    @Autowired
    public TicketController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Ticket> getUserTickets(Principal principal){
        User user = userRepository.findByEmail(principal.getName());
        return user.getTicketList();
    }

}
