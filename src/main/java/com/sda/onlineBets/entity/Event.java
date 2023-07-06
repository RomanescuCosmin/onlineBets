package com.sda.onlineBets.entity;

import com.sda.onlineBets.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDateTime dateTimeEvent;
    private String oddTeamA;
    private String oddTeamB;
    private String oddX;

    private League league;
//    private BasketLeague basketLeague;
//    private TennisLeague tennisLeague;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "event")
    private List<Bet> bets;


}
