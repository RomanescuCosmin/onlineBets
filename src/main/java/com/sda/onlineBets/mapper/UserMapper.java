package com.sda.onlineBets.mapper;

import com.sda.onlineBets.dto.UserDto;
import com.sda.onlineBets.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserMapper {

    public User map(UserDto userDto) {

        return User.builder()
                .userName(userDto.getUserName())
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .dateOfBirth(LocalDate.parse(userDto.getDateOfBirth()))
                .password(userDto.getPassword())
                .build();

    }



}
