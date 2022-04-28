package com.kajetanwiacek.concerttickets.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsUserByEmail(String email);
    User findByEmail(String email);
}
