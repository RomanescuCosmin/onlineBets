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
            .oddEvent(OddEvent.valueOf(eventDto.getOddEvent()))
            .category(Category.valueOf(eventDto.getCategory()))
            .dateEvent(LocalDate.parse(eventDto.getDateEvent().toString()))
            .build();
    }


}
