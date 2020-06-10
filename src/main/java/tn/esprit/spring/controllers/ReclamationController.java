package tn.esprit.spring.controllers;

import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.services.ReclamationServiceImpl;
import tn.esprit.spring.sms.Service;

@Scope(value = "session")
@Controller(value = "reclamationController")
@ELBeanName(value = "reclamationController")
@Join(path = "/Reclamationadmin", to = "/Reclamationadmin.jsf")
public class ReclamationController {

	@Autowired
	ReclamationServiceImpl reclamationService;
	@Autowired
	Service  mssg ;
	private List<Reclamation> reclamations;
	private List<Reclamation> ureclamations;
	private int idRec;
	private String sujetRec;
	private String ContenuRec;

	private Date dateRec;

	private Date dateT;

	private int etat;

	public int getIdRec() {
		return idRec;
	}

	public void setIdRec(int idRec) {
		this.idRec = idRec;
	}

	public String getSujetRec() {
		return sujetRec;
	}

	public void setSujetRec(String sujetRec) {
		this.sujetRec = sujetRec;
	}

	public String getContenuRec() {
		return ContenuRec;
	}

	public void setContenuRec(String contenuRec) {
		ContenuRec = contenuRec;
	}

	public Date getDateRec() {
		return dateRec;
	}

	public void setDateRec(Date dateRec) {
		this.dateRec = dateRec;
	}

	public Date getDateT() {
		return dateT;
	}

	public void setDateT(Date dateT) {
		this.dateT = dateT;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public List<Reclamation> getUreclamations() {
		return ureclamations;
	}

	public void setUreclamations(List<Reclamation> ureclamations) {
		this.ureclamations = ureclamations;
	}

	private User user;
	private long authenticatedUser;

	public long getAuthenticatedUser() {
		return authenticatedUser;
	}

	public void setAuthenticatedUser(long authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}

	public List<Reclamation> getReclamations() {
		reclamations = reclamationService.getAllReclamations();
		return reclamations;
	}

	public List<Reclamation> getUReclamations(User u) {
		ureclamations = reclamationService.getUReclamations(u);
		return ureclamations;
	}

	public Reclamation traiter(Reclamation r,User user) {
		// System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
//		this.setIdRec(r.getIdRec());
//		this.setContenuRec(r.getContenuRec());
//		this.setDateRec(r.getDateRec());
//		this.setDateT(r.getDateT());
//		this.setSujetRec(r.getSujetRec());
//		this.setEtat(1);
//		System.out.println(r);

//		return reclamationService.traiterReclamation(new Reclamation(idRec,  sujetRec,  ContenuRec, dateRec, dateT,  etat));
		System.out.println(reclamationService.tel(user.getId()));
		
	//mssg.msg(reclamationService.tel(user.getId()));
		
		return reclamationService.traiterReclamation(r);
	}

	public void addrec(User u) {

		reclamationService.ajouterReclamation(new Reclamation(idRec, sujetRec, ContenuRec, null, null, 0, u));
	}
	
	public void add(Reclamation r) {

		reclamationService.ajouterReclamation(r);
	}

	public String afficher(Reclamation r) {
		this.setIdRec(r.getIdRec());
		this.setContenuRec(r.getContenuRec());
		this.setDateRec(r.getDateRec());
		this.setDateT(r.getDateT());
		this.setSujetRec(r.getSujetRec());
		this.setEtat(r.getEtat());
		return "/reclamationdetail.xhtml?faces-redirect=true";
	}

public void removeR(String ids)
{
		reclamationService.deleteReclamation(ids);
	
		
	}	


}
