package tn.esprit.spring.controllers;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Evenements;
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Participants;
import tn.esprit.spring.repository.ParticipantsRepository;
import tn.esprit.spring.services.ParticipantsService;

@Scope(value = "session")
@Controller(value = "participantsController")
@ELBeanName(value = "participantsController")
@Join(path = "/jardin", to = "/jardin.jsf")
public class ParticipantsController {
	
	@Autowired
	ParticipantsService participantsService;
	
	@Autowired
	ParticipantsRepository participantsRepository;
	
	private long idParticip;
	private String nomParticip;
	private String prenomParticip;
	private String numParticip;
	private String mailParticip;
	
	private Evenements event;
	private String nomE;
	private long idEvent;
	
	private Jardin jardin;
	private String nomJ;
	
	private Parent parent;
	private long id;
	
	
	// Liste de tous les participants getParticipants
	private List<Participants> participants;

	public List<Participants> getAllParticip() {
		participants = participantsService.getParticipants();
		return participants;
	}
	
	// Remove participants
		public void removeParticip(String idParticip) {
			participantsService.deleteParticipants(idParticip);
		}
	
	// Liste participants par idEvent
	public List<Participants> getAllParticipantsByIdEvent(long idEvent){
		return participantsRepository.getAllParticipantsByIdEvent(idEvent);
		
	}
	
	// Nombre participants par event
	public int nbParticipants(long idEvent){
		return participantsService.getNombreParticipantsByidEvent(idEvent);
	}
	
	// Participer à un event
	public void userparticipevent(Parent parent,long idEvent){
		participantsService.ParticiperEvent(parent.getId(), idEvent); 
	}


	public ParticipantsService getParticipantsService() {
		return participantsService;
	}


	public void setParticipantsService(ParticipantsService participantsService) {
		this.participantsService = participantsService;
	}


	public ParticipantsRepository getParticipantsRepository() {
		return participantsRepository;
	}


	public void setParticipantsRepository(ParticipantsRepository participantsRepository) {
		this.participantsRepository = participantsRepository;
	}

	

	public List<Participants> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participants> participants) {
		this.participants = participants;
	}

	public long getIdParticip() {
		return idParticip;
	}


	public void setIdParticip(long idParticip) {
		this.idParticip = idParticip;
	}


	public String getNomParticip() {
		return nomParticip;
	}


	public void setNomParticip(String nomParticip) {
		this.nomParticip = nomParticip;
	}


	public String getPrenomParticip() {
		return prenomParticip;
	}


	public void setPrenomParticip(String prenomParticip) {
		this.prenomParticip = prenomParticip;
	}


	public String getNumParticip() {
		return numParticip;
	}


	public void setNumParticip(String numParticip) {
		this.numParticip = numParticip;
	}


	public String getMailParticip() {
		return mailParticip;
	}


	public void setMailParticip(String mailParticip) {
		this.mailParticip = mailParticip;
	}


	public Evenements getEvent() {
		return event;
	}


	public void setEvent(Evenements event) {
		this.event = event;
	}


	public long getIdEvent() {
		return idEvent;
	}


	public void setIdEvent(long idEvent) {
		this.idEvent = idEvent;
	}


	public ParticipantsController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Jardin getJardin() {
		return jardin;
	}

	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}

	public String getNomJ() {
		return nomJ;
	}

	public void setNomJ(String nomJ) {
		this.nomJ = nomJ;
	}
	

	public String getNomE() {
		return nomE;
	}

	public void setNomE(String nomE) {
		this.nomE = nomE;
	}

	public ParticipantsController(long idParticip, String nomParticip, String prenomParticip, String numParticip,
			String mailParticip) {
		super();
		this.idParticip = idParticip;
		this.nomParticip = nomParticip;
		this.prenomParticip = prenomParticip;
		this.numParticip = numParticip;
		this.mailParticip = mailParticip;
	}


	public ParticipantsController(long idParticip, String nomParticip, String prenomParticip, String numParticip,
			String mailParticip, Evenements event, long idEvent) {
		super();
		this.idParticip = idParticip;
		this.nomParticip = nomParticip;
		this.prenomParticip = prenomParticip;
		this.numParticip = numParticip;
		this.mailParticip = mailParticip;
		this.event = event;
		this.idEvent = idEvent;
	}

	public ParticipantsController(long idParticip, String nomParticip, String prenomParticip, String numParticip,
			String mailParticip, Evenements event) {
		super();
		this.idParticip = idParticip;
		this.nomParticip = nomParticip;
		this.prenomParticip = prenomParticip;
		this.numParticip = numParticip;
		this.mailParticip = mailParticip;
		this.event = event;
	}

	public ParticipantsController(long idParticip, String nomParticip, String prenomParticip, String numParticip,
			String mailParticip, Evenements event, Jardin jardin) {
		super();
		this.idParticip = idParticip;
		this.nomParticip = nomParticip;
		this.prenomParticip = prenomParticip;
		this.numParticip = numParticip;
		this.mailParticip = mailParticip;
		this.event = event;
		this.jardin = jardin;
	}
	
	


}
