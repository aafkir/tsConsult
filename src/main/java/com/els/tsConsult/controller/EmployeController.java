package com.els.tsConsult.controller;

import com.els.tsConsult.business.IEmployesDto;
import com.els.tsConsult.models.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeController{

    @Autowired
    private IEmployesDto employesDto;

    @GetMapping("/employes")
    public List<Employe> getAllEmployes() {
        return employesDto.getAllEmplyes();
    }

    @PostMapping("/saveEmploye")
    public void addMember(@RequestBody Employe employe){
        employesDto.saveEmploye(employe);
    }


    @GetMapping("/employes/{id}")
    public Employe getEmployeByMatricule(@PathVariable String id) {
        return employesDto.getEmployeByMatricule(id);
    }
}
