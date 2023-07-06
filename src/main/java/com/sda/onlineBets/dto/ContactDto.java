package com.sda.onlineBets.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDto {

    private String name;
    private String email;
    private String message;

}
