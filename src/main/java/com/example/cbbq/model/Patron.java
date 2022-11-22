package com.example.cbbq.model;

import javax.persistence.*;

import org.springframework.lang.NonNull;

import java.util.Set;

@Entity
@Table(name = "patrons")
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String username;
    @NonNull
    private String name;
    private String phone;
    @NonNull
    private String password;
    @Transient
    private String passwordConfirm;
    @ManyToMany
    private Set<Organizer> favoriteOrgs;
    @ManyToMany
    private Set<Event> favoriteEvents;
    @ManyToMany
    private Set<Event> attendingEvents;

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPasswordConfirm() {
        return passwordConfirm;
    }
    
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    
    public Set<Organizer> getFavoriteOrgs() {
        return favoriteOrgs;
    }
    
    public void setFavoriteOrgs(Set<Organizer> favoriteOrgs) {
        this.favoriteOrgs = favoriteOrgs;
    }
    
    public Set<Event> getFavoriteEvents() {
        return favoriteEvents;
    }
    
    public void setFavoriteEvents(Set<Event> favoriteEvents) {
        this.favoriteEvents = favoriteEvents;
    }

    public Set<Event> getAttendingEvents() {
        return attendingEvents;
    }

    public void setAttendingEvents(Set<Event> attendingEvents) {
        this.attendingEvents = attendingEvents;
    }
}