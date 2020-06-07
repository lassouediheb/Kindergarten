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

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "T_inscrits")
public class Inscrits implements Serializable {



	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IDINSCRIP")
	long Idinscrip;
	@Column(name="Etat")
	private String etat="non paye";
	
	@Column(name="Nominscrit")
	String nominscrit;

	@Column(name="Prenominscrit")
	String prenominscrit;
	
	@Column(name="Numeroinsc")
	String numinsc;
	
	
	@ManyToOne
	Bus bus;


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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Inscrits(long idinscrip, String etat, String nominscrit, String prenominscrit, String numinsc, Bus bus) {
		super();
		Idinscrip = idinscrip;
		this.etat = etat;
		this.nominscrit = nominscrit;
		this.prenominscrit = prenominscrit;
		this.numinsc = numinsc;
		this.bus = bus;
	}


	public Inscrits(String etat, String nominscrit, String prenominscrit, String numinsc, Bus bus) {
		super();
		this.etat = etat;
		this.nominscrit = nominscrit;
		this.prenominscrit = prenominscrit;
		this.numinsc = numinsc;
		this.bus = bus;
	}
	
	






	



	
	
	
	
	
	
	
}
