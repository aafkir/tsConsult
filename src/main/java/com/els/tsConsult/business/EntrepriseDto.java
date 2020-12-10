package com.els.tsConsult.business;

import com.els.tsConsult.dao.EntrepriseRepository;
import com.els.tsConsult.models.Employe;
import com.els.tsConsult.models.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrepriseDto  implements  IEntrepriseDto{
@Autowired
private EntrepriseRepository entrepriseRepository;
    @Override
    public List<Employe> getEmployesByEntreprise(String id) {
        return entrepriseRepository.findById(id).get().getEmployes();
    }

    @Override
    public List<Entreprise> getAllEntreprise() {
        return entrepriseRepository.findAll();
    }

}
