package com.sda.onlineBets.repository;

import com.sda.onlineBets.entity.Bet;
import com.sda.onlineBets.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BetRepository extends CrudRepository<Bet, Long> {
    Iterable<Bet> findByUserEmail(String email);
}
