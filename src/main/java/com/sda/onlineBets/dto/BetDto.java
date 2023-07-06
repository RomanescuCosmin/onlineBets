package com.sda.onlineBets.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BetDto {

    private String user;
    private String event;
    private String stake;
    private String selection;
    private String dateAndTime;
    private String status;


}
