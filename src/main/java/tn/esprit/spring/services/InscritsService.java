package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Bus;
import tn.esprit.spring.entity.Inscrits;

public interface InscritsService {
	
	List<Inscrits> retrieveAllInscrits(); 
	Inscrits addInscrits(Inscrits In);
	void deleteInscrits(String matricule);
	Inscrits updateInscrits(Inscrits B);
	Inscrits retrieveInscrits(String Idinscrip);
//	public void inscr(String matricule, String Idinscrip);
//	public void desinscr(String matricule, String Idinscrip);
	
	public void InscrireBus(long id, long matricule);

}