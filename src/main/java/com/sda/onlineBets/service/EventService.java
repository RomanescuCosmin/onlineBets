package com.sda.onlineBets.service;

import com.sda.onlineBets.dto.EventDto;
import com.sda.onlineBets.entity.Event;
import com.sda.onlineBets.mapper.EventMapper;
import com.sda.onlineBets.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EventService {
    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private EventRepository eventRepository;

    public void addEvent(EventDto eventDto) {

        Event event = eventMapper.map(eventDto);
        eventRepository.save(event);
    }


    public List<EventDto> getAllEventDtoList() {
        Iterable<Event> eventList = eventRepository.findAll();
        List<EventDto> eventDtoList = new ArrayList<>();
        for (Event event : eventList) {
            EventDto eventDto = eventMapper.map(event);
            eventDtoList.add(eventDto);
        }
        System.out.println(eventDtoList.size());
        return eventDtoList;

    }

    public Map<String, List<EventDto>> groupEventsByLeague(List<EventDto> events) {
        return events.stream()
                .collect(Collectors.groupingBy(EventDto::getLeague));
    }


}



