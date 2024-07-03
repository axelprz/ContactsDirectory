package com.axelprz.contactsdirectory.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Table(name = "addresses")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String street;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_city")
    @JsonIgnoreProperties({"addresses", "hibernateLazyInitializer"})
    private City city;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "address")
    @JsonIgnoreProperties({"address", "hibernateLazyInitializer"})
    private Contact contact;

    public Address() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
