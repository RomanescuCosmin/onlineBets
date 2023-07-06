package com.sda.onlineBets.service;

import com.sda.onlineBets.dto.SelectionDto;
import com.sda.onlineBets.entity.Event;
import com.sda.onlineBets.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SelectionService {
    @Autowired
    private EventRepository eventRepository;
    public SelectionDto createSelection(String eventId,String selection){
        if(eventId==null){
            return new SelectionDto();
        }
        Optional<Event> optionalEvent = eventRepository.findById(Long.valueOf(eventId));
        if(optionalEvent.isEmpty()){
            return new SelectionDto();
        }
        Event event = optionalEvent.get();
        String odd=computeOdd(event,selection);
        return SelectionDto.builder()
                .information(event.getTeamA() + " vs. " + event.getTeamB() + " - " + selection )
                .odd(odd)
                .selection(selection)
                .eventId(eventId)
                .build();
    }

    private String computeOdd(Event event, String selection) {
       if(selection != null) {

           if (selection.equals("x")) {
               return event.getOddX();
           }
           if (selection.equals("1")) {
               return event.getOddTeamA();
           }
           if (selection.equals("2")) {
               return event.getOddTeamB();
           }
       }
       return "";
    }
}
