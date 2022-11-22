package com.example.cbbq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.example.cbbq.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    public Optional<Address> findById(Long id);
}