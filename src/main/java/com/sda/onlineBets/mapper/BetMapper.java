package com.sda.onlineBets.mapper;

import com.sda.onlineBets.dto.BetDto;
import com.sda.onlineBets.entity.Bet;
import com.sda.onlineBets.entity.Event;
import com.sda.onlineBets.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BetMapper {
    public Bet map(BetDto betDto){
        return Bet.builder()
//                .event(betDto.getEvent().toString())
//                .user(betDto.getUser())
                .stake(betDto.getStake())

                .build();
    }
    public BetDto map(Bet bet) {
        return BetDto.builder()
                .user(bet.getUser().getEmail())
                .event(bet.getEvent().getTeamA() +" vs "+ bet.getEvent().getTeamB())
                .stake(bet.getStake())
                .selection(bet.getSelection())
                .dateAndTime(transformDateTime(bet.getDateAndTime()))
                .status(bet.getStatus().name())
                .build();
    }
    private String transformDateTime(LocalDateTime dateTimeEvent) {
        return dateTimeEvent.toLocalDate().toString()+"  "+dateTimeEvent.toLocalTime().toString();
    }
}
