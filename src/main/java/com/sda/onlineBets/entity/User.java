package com.sda.onlineBets.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    private List<Bet> bets;


}
