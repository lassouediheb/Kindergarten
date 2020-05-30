package tn.esprit.spring.controllers;

import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Evenements;
import tn.esprit.spring.entity.Participants;
import tn.esprit.spring.services.EvenementsService;

@Scope(value = "session")
@Controller(value = "evenementsController")
@ELBeanName(value = "evenementsController")
@Join(path = "/evenement", to = "/evenement.jsf")
public class EvenementsController {
	
	@Autowired
	EvenementsService evenementsService;
	
	private long idEvent;
	private Evenements event;
	private Participants participants;
	private String nomE;
	private String adresseE;
	private Date dateE;
	private String descripE;
	private String etatE;
	private String imageE;
	private Integer nbPlace;
	private String statutE;
	
	private List<Evenements> events; 
	
	public List<Evenements> getEvenements() { 
		events = evenementsService.getAllEvenements(); 
		return events;
		}
	
	public void removeEvent(String idEvent) { 
		evenementsService.deleteEvenements(idEvent);
		}
	
	public void addEvent() { 
		evenementsService.addEvenements(new Evenements(nomE, adresseE, dateE, descripE, etatE, imageE, nbPlace, statutE)); }
	
	

	public EvenementsController(String nomE, String adresseE, Date dateE, String descripE, String etatE, String imageE,
			Integer nbPlace, String statutE) {
		super();
		this.nomE = nomE;
		this.adresseE = adresseE;
		this.dateE = dateE;
		this.descripE = descripE;
		this.etatE = etatE;
		this.imageE = imageE;
		this.nbPlace = nbPlace;
		this.statutE = statutE;
	}
	
	

	public EvenementsController() {
		super();
		// TODO Auto-generated constructor stub
	}



	public EvenementsController(List<Evenements> events) {
		super();
		this.events = events;
	}



	public EvenementsService getEvenementsService() {
		return evenementsService;
	}

	public void setEvenementsService(EvenementsService evenementsService) {
		this.evenementsService = evenementsService;
	}

	public long getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(long idEvent) {
		this.idEvent = idEvent;
	}

	public Evenements getEvent() {
		return event;
	}

	public void setEvent(Evenements event) {
		this.event = event;
	}

	public String getNomE() {
		return nomE;
	}

	public void setNomE(String nomE) {
		this.nomE = nomE;
	}

	public String getAdresseE() {
		return adresseE;
	}

	public void setAdresseE(String adresseE) {
		this.adresseE = adresseE;
	}

	public Date getDateE() {
		return dateE;
	}

	public void setDateE(Date dateE) {
		this.dateE = dateE;
	}

	public String getDescripE() {
		return descripE;
	}

	public void setDescripE(String descripE) {
		this.descripE = descripE;
	}

	public String getEtatE() {
		return etatE;
	}

	public void setEtatE(String etatE) {
		this.etatE = etatE;
	}

	public String getImageE() {
		return imageE;
	}

	public void setImageE(String imageE) {
		this.imageE = imageE;
	}

	public Integer getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(Integer nbPlace) {
		this.nbPlace = nbPlace;
	}

	public String getStatutE() {
		return statutE;
	}

	public void setStatutE(String statutE) {
		this.statutE = statutE;
	}

	public void setEvents(List<Evenements> events) {
		this.events = events;
	}



	public List<Evenements> getEvents() {
		return events;
	}
	
	

	

}
