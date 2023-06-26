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
    private String oddEvent;
    private String category;


}
