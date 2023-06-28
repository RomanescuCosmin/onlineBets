package com.sda.onlineBets.service;

import com.sda.onlineBets.dto.LoginDto;
import com.sda.onlineBets.entity.User;
import com.sda.onlineBets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public Boolean login(LoginDto loginDto) {
        Optional<User> optionalUser = userRepository.findByEmail(loginDto.getEmail());
        if (optionalUser.isEmpty()) {
            return false;
        }
        User user=optionalUser.get();
        return loginDto.getPassword().equals(user.getPassword());


    }


}
