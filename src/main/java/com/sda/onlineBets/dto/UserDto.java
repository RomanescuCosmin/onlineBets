package com.sda.onlineBets.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {

    @NotEmpty(message = "User name is mandatory!")
    @Size(min = 2, max = 20, message = "Name should be not too sort, not too long")
    private String userName;
    @Email
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String dateOfBirth;
    @NotEmpty
    private String phoneNumber;
    private String role;

}
