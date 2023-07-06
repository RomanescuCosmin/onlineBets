package com.sda.onlineBets.service;

import com.sda.onlineBets.dto.BetDto;
import com.sda.onlineBets.dto.EventDto;
import com.sda.onlineBets.dto.StakeDto;
import com.sda.onlineBets.entity.Bet;
import com.sda.onlineBets.entity.Event;
import com.sda.onlineBets.entity.User;
import com.sda.onlineBets.enums.BetStatus;
import com.sda.onlineBets.mapper.BetMapper;
import com.sda.onlineBets.repository.BetRepository;
import com.sda.onlineBets.repository.EventRepository;
import com.sda.onlineBets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BetService {

    private final BetMapper betMapper;
    private final BetRepository betRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Autowired
    public BetService(BetRepository betRepository, UserRepository userRepository, EventRepository eventRepository,BetMapper betMapper) {
        this.betRepository = betRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.betMapper=betMapper;
    }


    public void placeBet(String eventId, String selection, StakeDto stakeDto, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Optional<Event> optionalEvent = eventRepository.findById(Long.valueOf(eventId));

        // Am verificat daca exista vreun eveniment sau user.
        if (user == null || !optionalEvent.isPresent()) {
            throw new RuntimeException("User or event not found");
        }

        Event event = optionalEvent.get();


        Bet bet = Bet.builder()
                .user(user)
                .event(event)
                .stake(stakeDto.getStake())
                .dateAndTime(LocalDateTime.now())
                .status(BetStatus.IN_DESFASURARE)
                .selection(selection)
                .build();


        // Am salvat pariul in baza de date
        betRepository.save(bet);
    }

    public List<BetDto> getAllBetDtoListByEmail(String email) {
        System.out.println("Email received : " + email);
        Iterable<Bet> betList = betRepository.findByUserEmail(email);
        List<BetDto> betDtoList = new ArrayList<>();
        for (Bet bet : betList) {
            BetDto betDto = betMapper.map(bet);
            betDtoList.add(betDto);
        }
        System.out.println(betDtoList.size());
        return betDtoList;

    }

}

