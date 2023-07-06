package com.sda.onlineBets.mapper;

import com.sda.onlineBets.dto.EventDto;
import com.sda.onlineBets.entity.Event;
import com.sda.onlineBets.enums.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class EventMapper {
    public Event map(EventDto eventDto) {
        System.out.println("data si ora " + eventDto.getDateTimeEvent());
    return Event.builder()
            .teamA(eventDto.getTeamA())
            .teamB(eventDto.getTeamB())
            .oddTeamA(eventDto.getOddTeamA())
            .oddTeamB(eventDto.getOddTeamB())
            .oddX(eventDto.getOddX())
            .category(Category.valueOf(eventDto.getCategory()))
            .dateTimeEvent(LocalDateTime.parse(eventDto.getDateTimeEvent()))
            .league(League.valueOf(eventDto.getLeague()))

            .build();

    }

    public EventDto map(Event event){
        return  EventDto.builder()
                .teamA(event.getTeamA())
                .teamB(event.getTeamB())
                .category(event.getCategory().toString())
                .dateTimeEvent(transformDateTime(event.getDateTimeEvent()))
                .oddTeamA(event.getOddTeamA())
                .oddTeamB(event.getOddTeamB())
                .oddX(event.getOddX())
                .league(event.getLeague() == null ? "" : event.getLeague().getDisplayName() )

                .eventId(String.valueOf(event.getId()))
                .build();
    }

    private String transformDateTime(LocalDateTime dateTimeEvent) {
        return dateTimeEvent.toLocalDate().toString()+" at: "+dateTimeEvent.toLocalTime().toString();
    }


}
