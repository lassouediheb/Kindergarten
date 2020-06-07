package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="T_PARTICIPANT")
public class Participants implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PARTICIP")
	long idParticip;
	
	@Column(name="NOM_PARTICIP")
	String nomParticip;

	@Column(name="PRENOM_PARTICIP")
	String prenomParticip;
	
	@Column(name="NUM_PARTICIP")
	String numParticip;
	
	@Column(name="MAIL_PARTICIP")
	String mailParticip;
	
	@ManyToOne
	Evenements evenements;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Participants() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Participants(long idParticip, String nomParticip, String prenomParticip, String numParticip,
			String mailParticip) {
		super();
		this.idParticip = idParticip;
		this.nomParticip = nomParticip;
		this.prenomParticip = prenomParticip;
		this.numParticip = numParticip;
		this.mailParticip = mailParticip;
	}

	public Participants(String nomParticip, String prenomParticip, String numParticip, String mailParticip) {
		super();
		this.nomParticip = nomParticip;
		this.prenomParticip = prenomParticip;
		this.numParticip = numParticip;
		this.mailParticip = mailParticip;
	}

	

	public Evenements getEvenements() {
		return evenements;
	}

	public void setEvenements(Evenements evenements) {
		this.evenements = evenements;
	}

	public Participants(long idParticip, String nomParticip, String prenomParticip, String numParticip,
			String mailParticip, Evenements evenements) {
		super();
		this.idParticip = idParticip;
		this.nomParticip = nomParticip;
		this.prenomParticip = prenomParticip;
		this.numParticip = numParticip;
		this.mailParticip = mailParticip;
		this.evenements = evenements;
	}

	public Participants(String nomParticip, String prenomParticip, String numParticip, String mailParticip,
			Evenements evenements) {
		super();
		this.nomParticip = nomParticip;
		this.prenomParticip = prenomParticip;
		this.numParticip = numParticip;
		this.mailParticip = mailParticip;
		this.evenements = evenements;
	}

	
	
	
	
	
	
}