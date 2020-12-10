package com.els.tsConsult;

import com.els.tsConsult.dao.EmployeRepository;
import com.els.tsConsult.dao.EntrepriseRepository;
import com.els.tsConsult.models.Employe;
import com.els.tsConsult.models.Entreprise;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class})

	public class TsConsultApplication {

	public static void main(String[] args) {
		SpringApplication.run(TsConsultApplication.class, args);
	}

	@Bean
	CommandLineRunner start(EmployeRepository employeRepository, EntrepriseRepository entrepriseRepository){

		return args -> {
			entrepriseRepository.deleteAll();
			Stream.of("E1 entreprise1", "E2 entreprise2").forEach(e -> {
				entrepriseRepository.save(new Entreprise(e.split(" ")[0], e.split(" ")[1], "SARL",LocalDate.now(), new ArrayList<>()));
			});

			Entreprise entreprise1 = entrepriseRepository.findById("E1").get();
			Stream.of("emplNom1 empPrenom1 matricule1 ", "emplNom2 empPrenom2 matricule2", "emplNom1 empPrenom1 matricule3").forEach(em -> {
				Employe e=employeRepository.save(new Employe(null,em.split(" ")[2], em.split(" ")[0], em.split(" ")[1], new Date(), entreprise1));
				entreprise1.getEmployes().add(e);
				entrepriseRepository.save(entreprise1);

			});

 			Entreprise entreprise2 = entrepriseRepository.findById("E2").get();
			Stream.of("emplNom21 empPrenom21 matricule21 ", "emplNom22 empPrenom22 matricule22", "emplNom21 empPrenom21 matricule23").forEach(em -> {
				Employe e =employeRepository.save(new Employe(null,em.split(" ")[2], em.split(" ")[0], em.split(" ")[1], new Date(), entreprise2));
				entreprise2.getEmployes().add(e);
				entrepriseRepository.save(entreprise2);
			});
     	};
	}



}

