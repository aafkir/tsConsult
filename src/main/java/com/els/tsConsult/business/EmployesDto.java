package com.els.tsConsult.business;

import com.els.tsConsult.dao.EmployeRepository;
import com.els.tsConsult.models.Employe;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployesDto  implements  IEmployesDto{

    private static final Logger logger = Logger.getLogger(EmployesDto.class);
    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public Employe getEmployeByMatricule(String registrationNumber) {
        return employeRepository.findByRegistrationNumber(registrationNumber);
    }

    @Override
    public Employe saveEmploye(Employe e){
        Boolean checkExistingEmlp = checkUniqueEmploye(getAllEmplyes(), e);
        if(checkExistingEmlp)
            return employeRepository.save(e);
        else
            logger.error("Salarié avec matricule "+e.getRegistrationNumber()+" existe deja");
            return null;
    }

    @Override
    public List<Employe> getAllEmplyes(){
        return  employeRepository.findAll();
    }

    public boolean checkUniqueEmploye(List<Employe> employeList,Employe employe ){
        List<Employe> listchecked= employeList.stream()
                .filter(e-> e.getRegistrationNumber().equals(employe.getRegistrationNumber())).collect(Collectors.toList());

        return listchecked.isEmpty() ? true : false;
    }






}
