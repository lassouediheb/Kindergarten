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
	
	@Column(name="NOM_EVENT")
	String nomEvent;
	
	public String getNomEvent() {
		return nomEvent;
	}

	public void setNomEvent(String nomEvent) {
		this.nomEvent = nomEvent;
	}

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

	

	public Evenements getEvenements() {
		return evenements;
	}

	public void setEvenements(Evenements evenements) {
		this.evenements = evenements;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Participants [idParticip=" + idParticip + ", nomParticip=" + nomParticip + ", nomEvent=" + nomEvent
				+ ", evenements=" + evenements + "]";
	}

	

	public Participants(long idParticip, String nomParticip, String nomEvent, Evenements evenements) {
		super();
		this.idParticip = idParticip;
		this.nomParticip = nomParticip;
		this.nomEvent = nomEvent;
		this.evenements = evenements;
	}

	public Participants() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}