package com.sda.onlineBets.validate;

import com.sda.onlineBets.dto.UserDto;
import com.sda.onlineBets.entity.User;
import com.sda.onlineBets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@Component
public class UserValidator {

    @Autowired
    private UserRepository userRepository;

    public void validate(UserDto userDto, BindingResult bindingResult) {
        validateDateOfBirth(userDto, bindingResult);
        validateUniqueEmail(userDto, bindingResult);
        validateEmailContainsSpecialCharacters(userDto, bindingResult);
        validateUserNameNotEmpty(userDto, bindingResult);
    }

    private void validateDateOfBirth(UserDto userDto, BindingResult bindingResult) {
        if (userDto.getDateOfBirth().isEmpty()) {
            FieldError fieldError = new FieldError("userDto", "dateOfBirth",
                    "Date of birth should be filled!");
            bindingResult.addError(fieldError);
        }

        try {
            LocalDate.parse(userDto.getDateOfBirth());
        } catch (DateTimeParseException e) {
            FieldError fieldError = new FieldError("userDto", "dateOfBirth",
                    "Wrong format!");
            bindingResult.addError(fieldError);

        }
    }

    private static void validateEmailContainsSpecialCharacters(UserDto userDto, BindingResult bindingResult) {
        if (!userDto.getEmail().matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            FieldError fieldError = new FieldError("userDto", "email", "Email invalid !");
            bindingResult.addError(fieldError);
        }
    }

    private void validateUniqueEmail(UserDto userDto, BindingResult bindingResult) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()) {
            FieldError fieldError = new FieldError("userDto", "email", "Email is already use ! ");
            bindingResult.addError(fieldError);
        }
    }


    private static void validateUserNameNotEmpty(UserDto userDto, BindingResult bindingResult) {
        if (userDto.getUserName().isEmpty()) {
            FieldError fieldError = new FieldError("userDto", "lastName", "Last name should not be empty!");
            bindingResult.addError(fieldError);
        }
        try {
            LocalDate.parse(userDto.getDateOfBirth());

        } catch (DateTimeParseException exception) {
            FieldError fieldError = new FieldError("userDto", "dateOfBirth", "Wrong format!");
            bindingResult.addError(fieldError);
        }
    }


}
