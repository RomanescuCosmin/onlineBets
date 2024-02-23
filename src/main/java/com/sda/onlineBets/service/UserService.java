package com.sda.onlineBets.service;
import com.sda.onlineBets.dto.UserDto;
import com.sda.onlineBets.entity.User;
import com.sda.onlineBets.mapper.UserMapper;
import com.sda.onlineBets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    public List<UserDto> getAllUserDtoList() {
        List<UserDto> userDtoList = new ArrayList<>();
        Iterable<User> userIterable = userRepository.findAll();
        for (User user : userIterable) {
            UserDto userDto = userMapper.map(user);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }
    public Optional<UserDto> getUserDtoByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty()){
            return Optional.empty();
        }
        User user = optionalUser.get();
        UserDto userDto = userMapper.map(user);
        return Optional.of(userDto);
    }
}
