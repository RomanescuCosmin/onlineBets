package com.sda.onlineBets.mapper;

import com.sda.onlineBets.dto.EventDto;
import com.sda.onlineBets.entity.Event;
import com.sda.onlineBets.enums.Category;
import com.sda.onlineBets.enums.OddEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class EventMapper {
    public Event map(EventDto eventDto) {
    return Event.builder()
            .teamA(eventDto.getTeamA())
            .teamB(eventDto.getTeamB())
            .oddTeamA(eventDto.getOddTeamA())
            .oddTeamB(eventDto.getOddTeamB())
            .oddX(eventDto.getOddX())
            .category(Category.valueOf(eventDto.getCategory()))
            .dateEvent(LocalDate.parse(eventDto.getDateEvent().toString()))
            .build();

    }

    public EventDto map(Event event){
        return  EventDto.builder()
                .teamA(event.getTeamA())
                .teamB(event.getTeamB())
                .category(event.getCategory().toString())
                .dateEvent(LocalDate.parse(event.getDateEvent().toString()))
                .oddTeamA(event.getOddTeamA())
                .oddTeamB(event.getOddTeamB())
                .oddX(event.getOddX())
                .build();
    }


}
