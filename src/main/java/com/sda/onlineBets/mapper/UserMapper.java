package com.sda.onlineBets.mapper;

import com.sda.onlineBets.dto.UserDto;
import com.sda.onlineBets.entity.User;
import com.sda.onlineBets.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserMapper {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User map(UserDto userDto) {
        String passwordEncoded = bCryptPasswordEncoder.encode(userDto.getPassword());

        return User.builder()
                .userName(userDto.getUserName())
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .dateOfBirth(LocalDate.parse(userDto.getDateOfBirth()))
                .password(passwordEncoded)
                .role(Role.valueOf(userDto.getRole()))
                .build();

    }
    public UserDto map(User user){
        return UserDto.builder()
                .email(user.getEmail())
                .userName(user.getUserName())
                .phoneNumber(user.getPhoneNumber())
                .dateOfBirth(user.getDateOfBirth() != null ? user.getDateOfBirth().toString() : "")
                .role(user.getRole() != null ? user.getRole().getRoleName() : "")
                .build();
    }


}
