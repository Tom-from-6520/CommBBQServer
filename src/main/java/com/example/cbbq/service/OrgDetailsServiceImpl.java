package com.example.cbbq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

import com.example.cbbq.model.Organizer;
import com.example.cbbq.repository.OrganizerRepository;

@Service
public class OrgDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private OrganizerRepository organizerRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Organizer organizer = organizerRepository.findByUsername(username);
        if (organizer == null) {
            throw new UsernameNotFoundException("Organizer not found");
        }
        return new User(organizer.getUsername(), organizer.getPassword(), new HashSet<>());
    }
}
