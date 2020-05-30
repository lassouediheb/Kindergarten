package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Directeurs;

public interface DirecteursService {
	List<Directeurs> retrieveAllDirecteurs();
	Directeurs addDirecteurs(Directeurs e); 
	void deleteDirecteurs(String id);
	Directeurs updateDirecteurs(Directeurs e);
	Directeurs retrieveDirecteurs(String id);


}
