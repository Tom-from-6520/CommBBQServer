package com.example.cbbq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.cbbq.model.Organizer;
import com.example.cbbq.repository.OrganizerRepository;

@Service
public class OrgServiceImpl implements OrgService {
    @Autowired
    private OrganizerRepository organizerRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Organizer organizer) {
        organizer.setPassword(bCryptPasswordEncoder.encode(organizer.getPassword()));
        organizerRepository.save(organizer);
    }

    @Override
    public Organizer findByUsername(String username) {
        Organizer organizer = organizerRepository.findByUsername(username);
        if (organizer == null) 
            organizer = organizerRepository.findByUsername(username);
        return organizer;
    }
}
