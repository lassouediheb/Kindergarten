package tn.esprit.spring.controllers;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import tn.esprit.spring.entity.Bus;
import tn.esprit.spring.entity.Evenements;
import tn.esprit.spring.entity.Inscrits;
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.BusRepository;
import tn.esprit.spring.services.BusService;
import tn.esprit.spring.services.InscritsService;

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
	private long idbustobeupdated;
	
	public Bus getBuss() {
		return buss;
	}









	public long getIdbustobeupdated() {
		return idbustobeupdated;
	}









	public void setIdbustobeupdated(long idbustobeupdated) {
		this.idbustobeupdated = idbustobeupdated;
	}









	public String getA() {
		return a;
	}









	public void setA(String a) {
		this.a = a;
	}









	public void setBuss(Bus buss) {
		this.buss = buss;
	}

	public Inscrits getInscrits() {
		return inscrits;
	}

	public String addBus1(Jardin jardin) {
		busService.addbus(new Bus(NomChauf, Depart, arrivee, trajet, TarifB, nbrPlace,jardin));
		return "null";
		}
	
	
	//modifier
	public void modifierBus1(Jardin jardin) {
		busService.updateBus(
				new Bus(idbustobeupdated,NomChauf, Depart, arrivee, trajet, TarifB, nbrPlace,jardin));
		
		}
	//supprimer bus
	public void supprimerbus(String matricule) {
		busService.deleteBus(matricule);
	}
	//afficher liste participants
	private long idB;
	public String listeparBus(Bus bus ) 
	{ 	
		this.setBuss(bus);
		this.setIdB(bus.getMatricule());
	return "listeinscrip.xhtml?faces-redirect=true"; 
	}
	
//display bus:
	
	public long getIdB() {
		return idB;
	}









	public void setIdB(long idB) {
		this.idB = idB;
	}









	public void displayBus(Bus bus) {
		
		this.setNomChauf(bus.getNomChauf());
		this.setDepart(bus.getDepart());
		this.setArrivee(bus.getArrivee());
		this.setTrajet(bus.getTrajet());
		this.setTarifB(bus.getTarifB());
		this.setNbrPlace(bus.getNbrPlace());
		this.setIdbustobeupdated(bus.getMatricule());
		this.setJardin(getJardin());
		
	}
	
// afficher bus par id
	
	public List<Bus> getBusByIdJ(Jardin jardin){
		return busRepository.getAllBusById(jardin.getId());
	} 
	
	public Bus getBusBymatricule() {
		return busRepository.getBusById(outcome());
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
	
	
	String a;
	private String getCountryFromJSF(FacesContext context) {
		Map<String, String> parameters = context.getExternalContext().getRequestParameterMap();
		return parameters.get("matricule1");
	}
	public long outcome() {
		FacesContext context = FacesContext.getCurrentInstance();
		a = getCountryFromJSF(context);
		System.out.println("((((((((((((((((("+a);
		return Long.parseLong(a);
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
