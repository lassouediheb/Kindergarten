package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.User;


public interface ReclamationService {
	public Reclamation ajouterReclamation(Reclamation reclamation);
	List<Reclamation> retrieveAllReclamation();
	List<Reclamation> SearchBySujet(String description);
	List<Reclamation> SujetOrderDesc(String kelma);
	public Reclamation updateReclamation(Reclamation R);
	public void deleteReclamation(String id) ;
	public int getNombreReclamationJPQL() ;
	public Reclamation traiterReclamation(Reclamation R);
	List <Number>dateDeTraitement();
	public int matchStrings(String firstString, String SecondString);
	public List<Reclamation> getAllReclamations();
	
	public List<Reclamation> getUReclamations(User u);
	public int getNombreRmonth(int m) ;
	public int getNombreTmonth(int m) ;
	public String tel(long i);
//
}
