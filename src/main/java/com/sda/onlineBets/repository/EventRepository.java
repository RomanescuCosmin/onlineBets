package com.sda.onlineBets.repository;

import com.sda.onlineBets.entity.Event;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event,Long> {
}
