package com.sda.onlineBets.validate;

import com.sda.onlineBets.dto.UserDto;
import com.sda.onlineBets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Component
public class UserValidator {

    @Autowired
    private UserRepository userRepository;





}
