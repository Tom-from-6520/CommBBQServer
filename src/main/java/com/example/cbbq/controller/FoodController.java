package com.example.cbbq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cbbq.model.*;
import com.example.cbbq.repository.*;

@Controller
@RequestMapping("/food")
public class FoodController {
    @Autowired
    FoodRepository foodRepository;
    
    @GetMapping("/")
    public @ResponseBody Iterable<Food> getAllFood() {
        return foodRepository.findAll();
    }

    @PostMapping("/")
    public @ResponseBody Food createFood(@RequestBody Food food) {
        Food newFood = new Food();
        newFood.setName(food.getName());
        foodRepository.save(newFood);
        return newFood;
    }

    @GetMapping("/{id}")
    public @ResponseBody Food getFood(@PathVariable(name = "id") String id) {
        return foodRepository.findById(Long.valueOf(id)).orElse(null);
    }
}
