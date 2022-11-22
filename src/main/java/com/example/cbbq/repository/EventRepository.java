package com.example.cbbq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import com.example.cbbq.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
    public Optional<Event> findById(Long id);
    public List<Event> findAllByName(String name);
    public List<Event> findAllByOrg_id(Long org_id);
}
