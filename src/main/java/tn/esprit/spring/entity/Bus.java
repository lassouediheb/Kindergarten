package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;




@Entity
@Table(name = "T_Bus")
public class Bus implements Serializable {
	
	
	
	

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="MATRICULE")
	long matricule;
	@Column(name="NOMCHAUF")

	private String NomChauf; // 

	 
	

	@Column(name="DEPART")


	private String Depart;  
	

	@Column(name="ARRIVEE")

	

	private String arrivee;  
	

	@Column(name="TRAJET")

	

	private String trajet; 
	

	@Column(name="TARIFB")


	private String TarifB;
	

	@Column(name="NBRPLACE")
	Integer nbrPlace;
	@Column(name="ETAT")
	String Etat="Dispo";
	
	@ManyToOne 
	Jardin jardin; 
	
	public Bus(String nomChauf, String depart, String arrivee, String trajet, String tarifB, Integer nbrPlace,
			String etat, Jardin jardin, Set<Inscrits> inscrits) {
		super();
		NomChauf = nomChauf;
		Depart = depart;
		this.arrivee = arrivee;
		this.trajet = trajet;
		TarifB = tarifB;
		this.nbrPlace = nbrPlace;
		Etat = etat;
		this.jardin = jardin;
		this.inscrits = inscrits;
	}
	public Bus(long matricule, String nomChauf, String depart, String arrivee, String trajet, String tarifB,
			Integer nbrPlace, String etat, Jardin jardin, Set<Inscrits> inscrits) {
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
		this.inscrits = inscrits;
	}
	public Jardin getJardin() {
		return jardin;
	}
	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}
	public Set<Inscrits> getInscrits() {
		return inscrits;
	}
	public void setInscrits(Set<Inscrits> inscrits) {
		this.inscrits = inscrits;
	}
	public Integer getNbrPlace() {
		return nbrPlace;
	}
	public void setNbrPlace(Integer nbrPlace) {
		this.nbrPlace = nbrPlace;
	}
	@OneToMany(cascade = CascadeType.ALL, mappedBy="bus")
	private Set<Inscrits> inscrits ;

	public String getEtat() {
		return Etat;
	}
	public void setEtat(String etat) {
		Etat = etat;
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
	@Override
	public String toString() {
		return "Bus [matricule=" + matricule + ", NomChauf=" + NomChauf + ", Depart=" + Depart + ", arrivee=" + arrivee
				+ ", trajet=" + trajet + ", TarifB=" + TarifB + ", nbrPlace=" + nbrPlace + ", Etat=" + Etat
				+ "]";
	}
	public Bus(String nomChauf, String depart, String arrivee, String trajet, String tarifB, Integer nbrPlace,
			String etat, Set<Inscrits> inscrits) {
		super();
		this.NomChauf = nomChauf;
		this.Depart = depart;
		this.arrivee = arrivee;
		this.trajet = trajet;
		this.TarifB = tarifB;
		this.nbrPlace = nbrPlace;
		this.Etat = etat;
		this.inscrits = inscrits;
	}
	public Bus(long matricule, String nomChauf, String depart, String arrivee, String trajet, String tarifB,
			Integer nbrPlace, String etat, Set<Inscrits> inscrits) {
		super();
		this.matricule = matricule;
		this.NomChauf = nomChauf;
		this.Depart = depart;
		this.arrivee = arrivee;
		this.trajet = trajet;
		this.TarifB = tarifB;
		this.nbrPlace = nbrPlace;
		this.Etat = etat;
		this.inscrits = inscrits;
	}
	public Bus() {
		super();
	}

	

	public Bus(String nomChauf, String depart, String arrivee, String trajet, String tarifB, Integer nbrPlace) {
		super();
		NomChauf = nomChauf;
		Depart = depart;
		this.arrivee = arrivee;
		this.trajet = trajet;
		TarifB = tarifB;
		this.nbrPlace = nbrPlace;
		
	}
	public Bus(String nomChauf, String depart, String arrivee, String trajet, String tarifB, Integer nbrPlace,
			Jardin jardin) {
		super();
		NomChauf = nomChauf;
		Depart = depart;
		this.arrivee = arrivee;
		this.trajet = trajet;
		TarifB = tarifB;
		this.nbrPlace = nbrPlace;
		this.jardin = jardin;
	}
	public Bus(long matricule,String nomChauf, String depart, String arrivee, String trajet, String tarifB, Integer nbrPlace,Jardin jardin
			) {
		super();
		this.matricule = matricule;
		NomChauf = nomChauf;
		Depart = depart;
		this.arrivee = arrivee;
		this.trajet = trajet;
		TarifB = tarifB;
		this.nbrPlace = nbrPlace;
		this.jardin = jardin;
		
	}
	

	
	
}
