package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PARENT")
@DiscriminatorValue(value="parent")
public class Parent extends User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="NOM_P")
	String nomP;
	@Column(name="PRENOM_P")
	String prenomP;
	@Column(name="ADRESSE_P")
	String adresseJ;
	@Column(name="NUM_P")
	String numP; 
	
	@ManyToOne 
	Jardin jardin;
	
	
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy="parent")
	private Set<Enfant> enfant;




	public String getNomP() {
		return nomP;
	}




	public void setNomP(String nomP) {
		this.nomP = nomP;
	}




	public String getPrenomP() {
		return prenomP;
	}




	public void setPrenomP(String prenomP) {
		this.prenomP = prenomP;
	}




	public String getAdresseJ() {
		return adresseJ;
	}




	public void setAdresseJ(String adresseJ) {
		this.adresseJ = adresseJ;
	}




	public String getNumP() {
		return numP;
	}




	public void setNumP(String numP) {
		this.numP = numP;
	}




	public Jardin getJardin() {
		return jardin;
	}




	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}




	public Set<Enfant> getEnfant() {
		return enfant;
	}




	public void setEnfant(Set<Enfant> enfant) {
		this.enfant = enfant;
	}




	public Parent(String nomP, String prenomP, String adresseJ, String numP, Jardin jardin, Set<Enfant> enfant) {
		super();
		this.nomP = nomP;
		this.prenomP = prenomP;
		this.adresseJ = adresseJ;
		this.numP = numP;
		this.jardin = jardin;
		this.enfant = enfant;
	}
	
	public Parent(String username, String email, String password) {
		super(username, email, password);
		// TODO Auto-generated constructor stub
	}
	
}