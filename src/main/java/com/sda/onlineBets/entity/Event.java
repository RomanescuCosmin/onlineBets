package com.sda.onlineBets.entity;

import com.sda.onlineBets.enums.Category;
import com.sda.onlineBets.enums.OddEvent;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


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

    @Enumerated(value = EnumType.STRING)
    private OddEvent oddEvent;

    @Enumerated(value = EnumType.STRING)
    private Category category;


}
