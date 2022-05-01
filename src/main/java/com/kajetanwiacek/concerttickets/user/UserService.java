package com.kajetanwiacek.concerttickets.user;

import com.kajetanwiacek.concerttickets.exception.EmailAlreadyTakenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(User user){
        if(userRepository.existsUserByEmail(user.getEmail())){
            throw new EmailAlreadyTakenException(user.getEmail());
        }
        user.encodePassword(passwordEncoder);
        userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(String email){
        return userRepository.findByEmail(email);
    }
}
