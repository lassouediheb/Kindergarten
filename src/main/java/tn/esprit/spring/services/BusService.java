package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.entity.Bus;
import tn.esprit.spring.entity.Evenements;

public interface BusService {
	
	List<Bus> retrieveAllBus(); 
	Bus addBus(Bus B);
	void deleteBus(String matricule);
	Bus updateBus(Bus B);
	Bus retrieveBus(String matricule);
	public int getNombreBus();
	List<Bus> getAllBus();
	public long addbus(Bus bus);
	

}
