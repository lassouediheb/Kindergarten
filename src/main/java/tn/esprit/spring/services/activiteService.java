package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Activités;


public interface activiteService {
	
	List<Activités> retrieveAllActivités(); 
	Activités addActivités(Activités A);
	void deleteActivités(String idact);
	Activités updateActivités(Activités A);
	Activités retrieveActivités(String idact);
	
	

}
