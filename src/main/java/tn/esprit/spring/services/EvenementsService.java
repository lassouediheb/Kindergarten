package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Evenements;

public interface EvenementsService {
	List<Evenements> retrieveAllEvenements();
	Evenements addEvenements(Evenements e); 
	void deleteEvenements(String id);
	Evenements updateEvenements(Evenements e);
	Evenements retrieveEvenements(String id);
	List<Evenements> getAllEvenements();


}
