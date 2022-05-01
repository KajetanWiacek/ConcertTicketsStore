package com.kajetanwiacek.concerttickets.order;

import com.kajetanwiacek.concerttickets.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderInfo,Long> {
    List<OrderInfo> getByUser(User user);
}
