package com.sda.onlineBets.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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


    private String userName;
    private String email;
    private String password;
    private String dateOfBirth;
    private String phoneNumber;
    private String role;

}
