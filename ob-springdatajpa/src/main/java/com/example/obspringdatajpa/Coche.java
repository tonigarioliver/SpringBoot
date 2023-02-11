package com.example.obspringdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coche {

    // atributos encapsulados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
    private String model;
    private Integer manufacturedYear;

    public Coche(Long id, String manufacturer, String model, Integer manufacturedYear) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.manufacturedYear = manufacturedYear;
    }

    public Coche() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(Integer manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }
}