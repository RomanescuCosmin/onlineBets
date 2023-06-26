package com.sda.onlineBets.repository;

import com.sda.onlineBets.entity.Event;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EventRepository extends CrudRepository<Event,Long> {
}
