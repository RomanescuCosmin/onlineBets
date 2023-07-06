package com.sda.onlineBets.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventDto {

    private String eventId;
    private String teamA;
    private String teamB;
    private String dateTimeEvent;
    private String oddTeamA;
    private String oddTeamB;
    private String oddX;
    private String category;
    private String league;

//    private String basketLeague;
//    private String tennisLeague;



}
