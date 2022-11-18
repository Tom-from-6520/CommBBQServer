package com.example.cbbq.model;

import javax.persistence.*;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Organizer organizer;

    @NonNull
    private String street_address;
    
    @NonNull
    private String city;
    
    @NonNull
    private String us_state;
    
    @NonNull
    private String zip_code;
    
    @NonNull
    private String country;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Organizer getOrganizer() {
        return organizer;
    }
    
    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }
    
    public String getStreet_address() {
        return street_address;
    }
    
    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getUs_state() {
        return us_state;
    }
    
    public void setUs_state(String us_state) {
        this.us_state = us_state;
    }
    
    public String getZip_code() {
        return zip_code;
    }
    
    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
}
