package com.els.tsConsult.controller;

import com.els.tsConsult.business.IEntrepriseDto;
import com.els.tsConsult.models.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntrepriseController {
    @Autowired
    private IEntrepriseDto entrepriseDto;

    @GetMapping("{entrepriseName}/employes")
    public List<Employe> getAllEmployes(String entrepriseId) {
        return entrepriseDto.getEmployesByEntreprise(entrepriseId);
    }


}
