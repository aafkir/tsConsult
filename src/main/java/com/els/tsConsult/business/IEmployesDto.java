package com.els.tsConsult.business;

import com.els.tsConsult.models.Employe;

import java.util.List;

public interface IEmployesDto {
    public Employe getEmployeByMatricule(String matricule);
    public Employe saveEmploye(Employe e);
    public List<Employe> getAllEmplyes();
}
