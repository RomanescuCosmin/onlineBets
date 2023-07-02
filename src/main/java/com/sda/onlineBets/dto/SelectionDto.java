package com.sda.onlineBets.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SelectionDto {
    private String odd;
    private String miza;
    private String potentialWinning;
    private String oddTeamA;
    private String oddTeamB;
    private String oddX;
    private String selection;

}
