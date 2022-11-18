package com.example.cbbq.service;

import com.example.cbbq.model.Organizer;

public interface OrgService {
    void save(Organizer organizer);
    Organizer findByUsername(String username);
}