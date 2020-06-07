package tn.esprit.spring.controllers;

import java.util.List;

import javax.persistence.Column;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Evenements;
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
	
	private Participants participants;
	private long idParticip;
	private String nomParticip;
	private String prenomParticip;
	private String numParticip;
	private String mailParticip;
	private Evenements event;
	private long idEvent;
	
	
	// Liste participants par idEvent
	public List<Participants> getAllParticipantsByIdEvent(long idEvent){
		return participantsRepository.getAllParticipantsByIdEvent(idEvent);
		
	}
	
	// Nombre participants par event
	public int nbParticipants(long idEvent){
		return participantsService.getNombreParticipantsByidEvent(idEvent);
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


	public Participants getParticipants() {
		return participants;
	}


	public void setParticipants(Participants participants) {
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

	
	
	
	
	
	

}
