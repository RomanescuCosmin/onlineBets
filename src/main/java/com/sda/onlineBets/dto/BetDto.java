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

}
