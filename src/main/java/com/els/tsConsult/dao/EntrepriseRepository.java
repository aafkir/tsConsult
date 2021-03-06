package com.els.tsConsult.dao;

import com.els.tsConsult.models.Entreprise;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface EntrepriseRepository extends MongoRepository<Entreprise, String> {
}
