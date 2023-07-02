package com.sda.onlineBets.mapper;

import com.sda.onlineBets.dto.BetDto;
import com.sda.onlineBets.entity.Bet;
import com.sda.onlineBets.entity.Event;
import com.sda.onlineBets.entity.User;
import org.springframework.stereotype.Component;

@Component
public class BetMapper {
    public Bet map(BetDto betDto){
        return Bet.builder()

                .build();
    }
    public BetDto map(Bet bet){
        return BetDto.builder()
                .event(bet.getEvent().toString())
                .user(bet.getUser().toString())
                .build();
    }
}
