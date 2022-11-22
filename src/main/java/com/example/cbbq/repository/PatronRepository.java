package com.example.cbbq.repository;

import java.util.Optional;

import com.example.cbbq.model.Patron;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepository extends JpaRepository<Patron, Long> {
    public Patron findByUsername(String username);
    public Optional<Patron> findById(Long id);
}