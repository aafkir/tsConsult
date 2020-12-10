package com.els.tsConsult.models;


import com.els.tsConsult.models.Entreprise;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "employes")

public class Employe {
    @Id
    private String id;

    @Indexed(unique=true)
    private String registrationNumber;
    private String firstname;
    private String lastname;
    private Date hiringDate;
    @DBRef
    private Entreprise entreprise;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date hiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Date getHiringDate() {
        return hiringDate;
    }

    public Employe(String id, String registrationNumber, String firstname, String lastname, Date hiringDate, Entreprise entreprise) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.hiringDate = hiringDate;
        this.entreprise = entreprise;
    }
}