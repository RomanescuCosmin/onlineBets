package com.sda.onlineBets.entity;

import com.sda.onlineBets.enums.Category;
import com.sda.onlineBets.enums.OddEvent;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teamA;
    private String teamB;
    private LocalDate dateEvent;
    private String oddTeamA;
    private String oddTeamB;
    private String oddX;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "event")
    private List<Bet> bets;


}
