package com.example.cbbq.model;

import java.util.Set;

import javax.persistence.*;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;

    @ManyToMany(mappedBy = "servingFoods")
    private Set<Event> featuredEvents;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name.toLowerCase().trim();
    }
}
