package com.els.tsConsult;

import com.els.tsConsult.business.EmployesDto;
import com.els.tsConsult.dao.EmployeRepository;
import com.els.tsConsult.models.Employe;
import com.els.tsConsult.models.Entreprise;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootTest
class TsConsultApplicationTests {

	@Test
	void checkUniqueEmployeTestOK(){
		Entreprise entrepriseTest = new Entreprise("E1","entrepriseTest","SARL", LocalDate.now(), new ArrayList<>());
		Employe employeTest= new Employe(null,"matricule4", "emplNom1", "empPrenom1", new Date(), entrepriseTest);

		Stream.of("emplNom1 empPrenom1 matricule1 ", "emplNom2 empPrenom2 matricule2", "emplNom1 empPrenom1 matricule3").forEach(em -> {
			entrepriseTest.getEmployes().add(new Employe(null,em.split(" ")[2], em.split(" ")[0], em.split(" ")[1], new Date(), entrepriseTest));
		});
		EmployesDto e = new EmployesDto();
		Assert.assertTrue(e.checkUniqueEmploye(entrepriseTest.getEmployes(),employeTest));
	}

	@Test
	void checkUniqueEmployeTestKO(){
		Entreprise entrepriseTest = new Entreprise("E1","entrepriseTest","SARL", LocalDate.now(), new ArrayList<>());
		Employe employeTest= new Employe(null,"matricule1", "emplNom1", "empPrenom1", new Date(), entrepriseTest);

		Stream.of("emplNom1 empPrenom1 matricule1 ", "emplNom2 empPrenom2 matricule2", "emplNom1 empPrenom1 matricule3").forEach(em -> {
			entrepriseTest.getEmployes().add(new Employe(null,em.split(" ")[2], em.split(" ")[0], em.split(" ")[1], new Date(), entrepriseTest));
		});
		EmployesDto e = new EmployesDto();
		Assert.assertFalse(e.checkUniqueEmploye(entrepriseTest.getEmployes(),employeTest));
	}




}
