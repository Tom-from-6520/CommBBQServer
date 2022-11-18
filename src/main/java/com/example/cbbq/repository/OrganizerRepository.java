package com.example.cbbq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cbbq.model.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
    public Organizer findByUsername(String username);
}
