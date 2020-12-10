package com.els.tsConsult.business;

import com.els.tsConsult.models.Employe;
import com.els.tsConsult.models.Entreprise;

import java.util.List;

public interface IEntrepriseDto {
    public List<Employe> getEmployesByEntreprise(String id);
    public List<Entreprise> getAllEntreprise();
}
