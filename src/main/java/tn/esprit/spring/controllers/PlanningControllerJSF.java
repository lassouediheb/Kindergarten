package tn.esprit.spring.controllers;

import java.io.IOException;
import java.util.Date;


import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;

import tn.esprit.spring.entity.Evenements;
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.entity.Planning;
import tn.esprit.spring.repository.PlanningRepository;
import tn.esprit.spring.services.PlanningServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Controller;


@Scope(value = "session")
@Controller(value ="planController")
@ELBeanName(value ="planController")
@Join(path = "/", to = "AffichagePlanning.jsf")
public class PlanningControllerJSF {
	
	
	
	@Autowired
	PlanningServiceImpl planningservice;
	@Autowired
	PlanningRepository planrepo ;
	private Planning planning;
	public Planning getPlanning() {
		return planning;
	}


	public void setPlanning(Planning planning) {
		this.planning = planning;
	}
	private Date date_debut;
	private Date date_fin;
	
	private List<Planning> plans; 
	private int id_planning;
	private Integer PlanningToBeUpdated;
	private Jardin jardin;
	


	public Integer getPlanningToBeUpdated() {
		return PlanningToBeUpdated;
	}


	public void setPlanningToBeUpdated(Integer planningToBeUpdated) {
		PlanningToBeUpdated = planningToBeUpdated;
	}


	public int getId_planning() {
		return id_planning;
	}


	public void setId_planning(int id_planning) {
		this.id_planning = id_planning;
	}


	public Date getDate_debut() {
		return date_debut;
	}


	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}


	public Date getDate_fin() {
		return date_fin;
	}


	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	
	
	public String addPlanning(Jardin jardin){
		planningservice.AddPlanning(new Planning(date_debut, date_fin, jardin));
		return "/AffichagePlanning.xhtml?faces-redirect=true";
		
		
	
		}
	

		
	public List<Planning> getPlans(Jardin jardin) {
		return planrepo.getAllPlansByIdJardin(jardin.getId());
		} 
	
	
	
	public void removePlanning(int id_planning)
	{
	planningservice.DeletePlanning(id_planning);	}
	
	
	
	public  List<Planning>  getAllPlansByIdJardin(long idJardin){
		return planrepo.getAllPlansByIdJardin(idJardin);
	}
	
	
	public String displayPlanning(Planning p)
	{
		
	this.setDate_debut(p.getDate_debut());
	this.setDate_fin(p.getDate_fin());
	this.setPlanningToBeUpdated(p.getId_planning());
	return "/editplanning.xhtml?faces-redirect=true";
	}
	
	
	
	public String updatePlanning() 
	{ 
		planningservice.AddPlanning(new Planning (PlanningToBeUpdated,date_debut, date_fin));
		return "/AffichagePlanning.xhtml?faces-redirect=true";
		}
	
	
	
	public String goFormAdd() {
		
		return "/AddPlan.xhtml?faces-redirect=true";
		}


	public PlanningServiceImpl getPlanningservice() {
		return planningservice;
	}


	public void setPlanningservice(PlanningServiceImpl planningservice) {
		this.planningservice = planningservice;
	}


	public PlanningRepository getPlanrepo() {
		return planrepo;
	}


	public void setPlanrepo(PlanningRepository planrepo) {
		this.planrepo = planrepo;
	}


	public Jardin getJardin() {
		return jardin;
	}


	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}


	public void setPlans(List<Planning> plans) {
		this.plans = plans;
	}


	
		
		

	
	
	


	
}
