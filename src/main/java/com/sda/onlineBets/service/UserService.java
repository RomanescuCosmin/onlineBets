package com.sda.onlineBets.service;


import com.sda.onlineBets.dto.UserDto;
import com.sda.onlineBets.entity.User;
import com.sda.onlineBets.mapper.UserMapper;
import com.sda.onlineBets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public void createUser(UserDto userDto) {
        User user = userMapper.map(userDto);
        userRepository.save(user);
    }

}
