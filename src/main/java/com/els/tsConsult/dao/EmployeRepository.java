package com.els.tsConsult.dao;

import com.els.tsConsult.models.Employe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface EmployeRepository  extends MongoRepository<Employe, String> {

    Employe findByFirstname(@Param("FirstName") String name);
    Employe findByRegistrationNumber(@Param("Matricule") String matricule);

}
