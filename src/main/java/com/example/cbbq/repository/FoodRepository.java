package com.example.cbbq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import com.example.cbbq.model.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
    public Optional<Food> findById(Long id);
    public List<Food> findAllByName(String name);
}
