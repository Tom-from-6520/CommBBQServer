package com.example.cbbq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.example.cbbq.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllById(Long id);
}