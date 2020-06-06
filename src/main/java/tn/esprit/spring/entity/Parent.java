package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="T_Parent")
@DiscriminatorValue(value="parent")
public class Parent extends User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="NOM_P")
	String nomP;
	@Column(name="PRENOM_P")
	String prenomP;
	@Column(name="ADRESSE_P")
	String adresseP;
	@Column(name="NUM_P")
	String numP; 
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Enfant> enfant;
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
	public String getAdresseP() {
		return adresseP;
	}
	public void setAdresseP(String adresseP) {
		this.adresseP = adresseP;
	}
	public String getNumP() {
		return numP;
	}
	public void setNumP(String numP) {
		this.numP = numP;
	}
	public List<Enfant> getEnfant() {
		return enfant;
	}
	public void setEnfant(List<Enfant> enfant) {
		this.enfant = enfant;
	}
	public Parent(String nomP, String prenomP, String adresseP, String numP, List<Enfant> enfant) {
		super();
		this.nomP = nomP;
		this.prenomP = prenomP;
		this.adresseP = adresseP;
		this.numP = numP;
		this.enfant = enfant;
	}
	
	

}
