package com.praticien.model;

public class Praticien {
    private Long id;
    private String firstName;
    private String lastName;
    private String speciality;

    public Praticien() {
    }

    public Praticien(Long id, String firstName, String lastName, String speciality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getSpecialty() {
        return speciality;
    }
    public void setSpecialty(String specialty) {
        this.speciality = specialty;
    }
}
