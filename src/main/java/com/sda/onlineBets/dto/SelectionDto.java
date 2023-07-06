package com.sda.onlineBets.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SelectionDto {

    private String information;
    private String odd;
    private String eventId;
    private String selection;

}
