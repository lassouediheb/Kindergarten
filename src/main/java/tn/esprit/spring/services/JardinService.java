package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Jardin;

public interface JardinService {
	List<Jardin> retrieveAllJardin();
	Jardin addJardin(Jardin j); 
	void deleteJardin(String id);
	Jardin updateJardin(Jardin j);
	Jardin retrieveJardin(String id);
	List<Jardin> getAllJardin();

}
