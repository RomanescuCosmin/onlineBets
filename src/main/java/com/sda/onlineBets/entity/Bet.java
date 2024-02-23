package com.sda.onlineBets.entity;

import com.sda.onlineBets.enums.BetStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Event event;
    private String stake;
    private LocalDateTime dateAndTime;
    private String selection;
    @Enumerated(EnumType.STRING)
    private BetStatus status;

    public void setStake(String stake) {
        this.stake = stake;
    }




}
