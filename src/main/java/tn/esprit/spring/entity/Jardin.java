package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_JARDIN")
@DiscriminatorValue(value="jd")
public class Jardin extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="NOM_J")
	String nomJ;
	@Column(name="LOGO_J")
	String logoJ;
	@Column(name="ADRESSE_J")
	String adresseJ;
	@Column(name="NUM_J")
	String numJ;
	@Temporal(TemporalType.DATE)
	private Date dateCrea;
	@Column(name="DESCRIPTION_J")
	String descripJ;
	@Column(name="TARIF_J")
	float tarifJ;
	
	
	@OneToOne
	private Directeurs directeurs; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="jardin")
	private Set<Evenements> Evenements;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy="jardin")
	private Set<Bus> Bus;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="jardin")
	private Set<Activités> Activités;
	public String getNomJ() {
		return nomJ;
	}
	


	public Jardin(String nomJ, String logoJ, String adresseJ, String numJ, Date dateCrea, String descripJ, float tarifJ,
			Directeurs directeurs, Set<tn.esprit.spring.entity.Evenements> evenements,
			Set<tn.esprit.spring.entity.Bus> bus, Set<tn.esprit.spring.entity.Activités> activités) {
		super();
		this.nomJ = nomJ;
		this.logoJ = logoJ;
		this.adresseJ = adresseJ;
		this.numJ = numJ;
		this.dateCrea = dateCrea;
		this.descripJ = descripJ;
		this.tarifJ = tarifJ;
		this.directeurs = directeurs;
		Evenements = evenements;
		Bus = bus;
		Activités = activités;
	}



	public Set<Bus> getBus() {
		return Bus;
	}



	public void setBus(Set<Bus> bus) {
		Bus = bus;
	}



	public Set<Activités> getActivités() {
		return Activités;
	}



	public void setActivités(Set<Activités> activités) {
		Activités = activités;
	}



	public void setNomJ(String nomJ) {
		this.nomJ = nomJ;
	}

	public String getLogoJ() {
		return logoJ;
	}

	public void setLogoJ(String logoJ) {
		this.logoJ = logoJ;
	}

	public String getAdresseJ() {
		return adresseJ;
	}

	public void setAdresseJ(String adresseJ) {
		this.adresseJ = adresseJ;
	}

	public String getNumJ() {
		return numJ;
	}

	public void setNumJ(String numJ) {
		this.numJ = numJ;
	}

	public Date getDateCrea() {
		return dateCrea;
	}

	public void setDateCrea(Date dateCrea) {
		this.dateCrea = dateCrea;
	}

	public String getDescripJ() {
		return descripJ;
	}

	public void setDescripJ(String descripJ) {
		this.descripJ = descripJ;
	}

	public float getTarifJ() {
		return tarifJ;
	}

	public void setTarifJ(float tarifJ) {
		this.tarifJ = tarifJ;
	}

	public Directeurs getDirecteurs() {
		return directeurs;
	}

	public void setDirecteurs(Directeurs directeurs) {
		this.directeurs = directeurs;
	}

	public Set<Evenements> getEvenements() {
		return Evenements;
	}

	public void setEvenements(Set<Evenements> evenements) {
		Evenements = evenements;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Jardin() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Jardin(String nomJ, String logoJ, String adresseJ, String numJ, Date dateCrea, String descripJ,
			float tarifJ) {
		super();
		this.nomJ = nomJ;
		this.logoJ = logoJ;
		this.adresseJ = adresseJ;
		this.numJ = numJ;
		this.dateCrea = dateCrea;
		this.descripJ = descripJ;
		this.tarifJ = tarifJ;
	}

	public Jardin(String nomJ, String logoJ, String adresseJ, String numJ, Date dateCrea, String descripJ, float tarifJ,
			Directeurs directeurs, Set<tn.esprit.spring.entity.Evenements> evenements) {
		super();
		this.nomJ = nomJ;
		this.logoJ = logoJ;
		this.adresseJ = adresseJ;
		this.numJ = numJ;
		this.dateCrea = dateCrea;
		this.descripJ = descripJ;
		this.tarifJ = tarifJ;
		this.directeurs = directeurs;
		Evenements = evenements;
	}

	@Override
	public String toString() {
		return "Jardin [nomJ=" + nomJ + ", logoJ=" + logoJ + ", adresseJ=" + adresseJ + ", numJ=" + numJ + ", dateCrea="
				+ dateCrea + ", descripJ=" + descripJ + ", tarifJ=" + tarifJ + ", directeurs=" + directeurs
				+ ", Evenements=" + Evenements + "]";
	}
	
	

}