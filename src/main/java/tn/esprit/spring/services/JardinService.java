package tn.esprit.spring.services;

import java.util.List;
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.entity.Publication;

public interface JardinService {
	
	List<Jardin> retrieveAllJardin();
	
	List<Jardin> getAllJardin();
	
	Jardin retrieveJardin(String id);
	
	Jardin addJardin(Jardin j); 
	
	Jardin updateJardin(Jardin j);

	void deleteJardin(String id);
	
	public List<Jardin> listAll(String keyword);
}

