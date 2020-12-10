package com.els.tsConsult.models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Document(collection = "entreprises")

public class Entreprise implements Serializable {
    @Id
    private String id;
    private String name;
    private String type;
    private LocalDate cerationDate;

    @DBRef
    private List<Employe> employes= new ArrayList<>();

    public Entreprise(String id, String name, String type, LocalDate cerationDate, List<Employe> employes) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.cerationDate = cerationDate;
        this.employes = employes;
    }

    public Entreprise(String name, String type, LocalDate cerationDate, List<Employe> employes) {
        this.name = name;
        this.type = type;
        this.cerationDate = cerationDate;
        this.employes = employes;
    }

    public Entreprise() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getCerationDate() {
        return cerationDate;
    }

    public void setCerationDate(LocalDate cerationDate) {
        this.cerationDate = cerationDate;
    }


    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public List<Employe> getEmployes() {
        return employes;
    }
}
