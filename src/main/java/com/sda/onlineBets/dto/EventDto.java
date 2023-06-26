package com.sda.onlineBets.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventDto {

    private String teamA;
    private String teamB;
    private LocalDate dateEvent;
    private String oddTeamA;
    private String oddTeamB;
    private String oddX;
    private String category;


}
