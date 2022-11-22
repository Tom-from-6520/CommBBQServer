package com.example.cbbq.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @ManyToOne
    private Organizer org;
    @ManyToOne
    private Address address;
    private String name;
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventTime;
    private String price;
    @ManyToMany
    private Set<Food> servingFoods;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Organizer getOrg() {
        return org;
    }

    public void setOrg(Organizer org) {
        this.org = org;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }

    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPrice() {
        return price;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }

    public Set<Food> getServingFoods() {
        return servingFoods;
    }

    public void setServingFoods(Set<Food> servingFoods) {
        this.servingFoods = servingFoods;
    }
}
