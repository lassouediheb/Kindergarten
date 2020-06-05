package tn.esprit.spring.controllers;

import java.util.List;



import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Bus;
import tn.esprit.spring.entity.Evenements;
import tn.esprit.spring.entity.Inscrits;
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.repository.BusRepository;
import tn.esprit.spring.services.BusService;

@Scope(value = "session")
@Controller(value = "busController")
@ELBeanName(value = "busController")
@Join(path = "/bus", to = "/bus.jsf")
public class BusController {

	@Autowired
	BusRepository busRepository;
	
	@Autowired
	BusService busService ;
	
	
	
	long matricule;
	private String NomChauf;
	private Inscrits inscrits ;
	private String Depart; 
	private String arrivee; 
	private String trajet; 
	private String TarifB;
	private Integer nbrPlace;
	private String Etat="Dispo"; 
	private Jardin jardin;
	private Bus buss ;
	private List<Bus> bus;
	
	
	public Bus getBuss() {
		return buss;
	}




	public void setBuss(Bus buss) {
		this.buss = buss;
	}

	public Inscrits getInscrits() {
		return inscrits;
	}




	public void setInscrits(Inscrits inscrits) {
		this.inscrits = inscrits;
	}


	public BusService getBusService() {
		return busService;
	}




	public void setBusService(BusService busService) {
		this.busService = busService;
	}




	public List<Bus> getBus1() { 
		bus = busService.getAllBus(); 
		return bus;
		}
	
	
	
	
	public void displayEvent(Bus bus) {
		this.setMatricule(bus.getMatricule());
		this.setNomChauf(bus.getNomChauf());
		this.setDepart(bus.getDepart());
		this.setArrivee(bus.getArrivee());
		this.setTrajet(bus.getTrajet());
		this.setTarifB(bus.getTarifB());
		this.setNbrPlace(bus.getNbrPlace());
		this.setEtat(bus.getEtat());
		
	}
	
	
	public BusRepository getBusRepository() {
		return busRepository;
	}







	public void setBusRepository(BusRepository busRepository) {
		this.busRepository = busRepository;
	}







	public List<Bus> getBus() {
		return bus;
	}







	public void setBus(List<Bus> bus) {
		this.bus = bus;
	}







	public long getMatricule() {
		return matricule;
	}
	
	
	public void setMatricule(long matricule) {
		this.matricule = matricule;
	}
	public String getNomChauf() {
		return NomChauf;
	}
	public void setNomChauf(String nomChauf) {
		NomChauf = nomChauf;
	}
	public String getDepart() {
		return Depart;
	}
	public void setDepart(String depart) {
		Depart = depart;
	}
	public String getArrivee() {
		return arrivee;
	}
	public void setArrivee(String arrivee) {
		this.arrivee = arrivee;
	}
	public String getTrajet() {
		return trajet;
	}
	public void setTrajet(String trajet) {
		this.trajet = trajet;
	}
	public String getTarifB() {
		return TarifB;
	}
	public void setTarifB(String tarifB) {
		TarifB = tarifB;
	}
	public Integer getNbrPlace() {
		return nbrPlace;
	}
	public void setNbrPlace(Integer nbrPlace) {
		this.nbrPlace = nbrPlace;
	}
	public String getEtat() {
		return Etat;
	}
	public void setEtat(String etat) {
		Etat = etat;
	}
	public Jardin getJardin() {
		return jardin;
	}
	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}
	public BusController(long matricule, String nomChauf, String depart, String arrivee, String trajet, String tarifB,
			Integer nbrPlace, String etat, Jardin jardin) {
		super();
		this.matricule = matricule;
		NomChauf = nomChauf;
		Depart = depart;
		this.arrivee = arrivee;
		this.trajet = trajet;
		TarifB = tarifB;
		this.nbrPlace = nbrPlace;
		Etat = etat;
		this.jardin = jardin;
	}


	public BusController() {
		super();
	} 
	
	
	
	
	
	
}
