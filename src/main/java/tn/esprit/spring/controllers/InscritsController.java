package tn.esprit.spring.controllers;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Bus;
import tn.esprit.spring.entity.Inscrits;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.repository.InscritsRepository;
import tn.esprit.spring.services.InscritsService;








@Scope(value = "session")
@Controller(value = "inscritsController")
@ELBeanName(value = "inscritsController")
@Join(path = "/inscrits", to = "/inscrits.jsf")
public class InscritsController {

	
	
	
	@Autowired
	InscritsRepository inscritRepository;
	@Autowired
	InscritsService insritsService;
	
	@Autowired
	InscritsService inscritService ; 
	private long matricule;
	private  long Idinscrip;
	private String etat="non paye";
	private String nominscrit;
	private String prenominscrit;
	private String numinsc;
	private Bus bus ;
	private Inscrits inscritss ; 
	
	
	
	
	
	
	


	// Liste participants par idEvent
	public List<Inscrits> getinscritsbus(long matricule){
		
		return inscritRepository.getinscribybus(matricule);
		
	}


	// inscrire bus
		public void userinscrire(Parent parent,long matricule){
			insritsService.InscrireBus(parent.getId(), matricule);
		}






	public InscritsController() {
		super();
		// TODO Auto-generated constructor stub
	}









	public InscritsRepository getInscritRepository() {
		return inscritRepository;
	}









	public void setInscritRepository(InscritsRepository inscritRepository) {
		this.inscritRepository = inscritRepository;
	}









	public InscritsService getInscritService() {
		return inscritService;
	}









	public void setInscritService(InscritsService inscritService) {
		this.inscritService = inscritService;
	}









	public long getMatricule() {
		return matricule;
	}









	public void setMatricule(long matricule) {
		this.matricule = matricule;
	}









	public long getIdinscrip() {
		return Idinscrip;
	}









	public void setIdinscrip(long idinscrip) {
		Idinscrip = idinscrip;
	}









	public String getEtat() {
		return etat;
	}









	public void setEtat(String etat) {
		this.etat = etat;
	}









	public String getNominscrit() {
		return nominscrit;
	}









	public void setNominscrit(String nominscrit) {
		this.nominscrit = nominscrit;
	}









	public String getPrenominscrit() {
		return prenominscrit;
	}









	public void setPrenominscrit(String prenominscrit) {
		this.prenominscrit = prenominscrit;
	}









	public String getNuminsc() {
		return numinsc;
	}









	public void setNuminsc(String numinsc) {
		this.numinsc = numinsc;
	}









	public Bus getBus() {
		return bus;
	}









	public void setBus(Bus bus) {
		this.bus = bus;
	}









	public Inscrits getInscritss() {
		return inscritss;
	}









	public void setInscritss(Inscrits inscritss) {
		this.inscritss = inscritss;
	}









	public InscritsController(InscritsRepository inscritRepository, InscritsService inscritService, long matricule,
			long idinscrip, String etat, String nominscrit, String prenominscrit, String numinsc, Bus bus,
			Inscrits inscritss) {
		super();
		this.inscritRepository = inscritRepository;
		this.inscritService = inscritService;
		this.matricule = matricule;
		Idinscrip = idinscrip;
		this.etat = etat;
		this.nominscrit = nominscrit;
		this.prenominscrit = prenominscrit;
		this.numinsc = numinsc;
		this.bus = bus;
		this.inscritss = inscritss;
	}









	public InscritsController(long matricule, long idinscrip, String etat, String nominscrit, String prenominscrit,
			String numinsc, Bus bus, Inscrits inscritss) {
		super();
		this.matricule = matricule;
		Idinscrip = idinscrip;
		this.etat = etat;
		this.nominscrit = nominscrit;
		this.prenominscrit = prenominscrit;
		this.numinsc = numinsc;
		this.bus = bus;
		this.inscritss = inscritss;
	}









	public InscritsController(String etat, String nominscrit, String prenominscrit, String numinsc) {
		super();
		this.etat = etat;
		this.nominscrit = nominscrit;
		this.prenominscrit = prenominscrit;
		this.numinsc = numinsc;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
