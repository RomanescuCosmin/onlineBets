package com.sda.onlineBets.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDto {


    @Email(message="Email is not valid!")
    private String email;

    @Size(min=3, message="Password is too short!")
    private String password;

}
