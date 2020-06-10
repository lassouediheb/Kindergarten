package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Evenements;
import tn.esprit.spring.entity.Publication;

public interface EvenementsService {
	List<Evenements> retrieveAllEvenements();
	
	List<Evenements> getAllEvenements();
	
	Evenements getEvenementByIdEvent(long idEvent);
	
	Evenements retrieveEvenements(String id);
	
	Evenements addEvenements(Evenements e,long id);
	
	Evenements updateEvenements(Evenements e);
	
	void deleteEvenements(String id);
	
	public List<Evenements> listAll(String keyword);
	
	public void sendMailEvent(long id);
	
	//public List<Evenements> getAllEventByIdJardin(long id);
}
