package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Reclamation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int idRec; // Clé primaire

	private String sujetRec;
	private String ContenuRec;
	@Temporal(TemporalType.DATE)
	private Date dateRec;
	@Temporal(TemporalType.DATE)
	private Date dateT;
	

	private int etat;
	
	@ManyToOne 
	User user;  
	
	
	
	public User getUser() {
		return user;
	}

	public Reclamation(int idRec, String sujetRec, String contenuRec, Date dateRec, Date dateT, int etat, User user) {
		super();
		this.idRec = idRec;
		this.sujetRec = sujetRec;
		ContenuRec = contenuRec;
		this.dateRec = dateRec;
		this.dateT = dateT;
		this.etat = etat;
		this.user = user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

	public int getEtat() {
		return etat;
	}

	public Reclamation() {

	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ContenuRec == null) ? 0 : ContenuRec.hashCode());
		result = prime * result + ((dateRec == null) ? 0 : dateRec.hashCode());
		result = prime * result + ((dateT == null) ? 0 : dateT.hashCode());
		result = prime * result + etat;
		result = prime * result + idRec;
		result = prime * result + ((sujetRec == null) ? 0 : sujetRec.hashCode());
		return result;
	}

	public Date getDateT() {
		return dateT;
	}

	public void setDateT(Date dateT) {
		this.dateT = dateT;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reclamation other = (Reclamation) obj;
		if (ContenuRec == null) {
			if (other.ContenuRec != null)
				return false;
		} else if (!ContenuRec.equals(other.ContenuRec))
			return false;
		if (dateRec == null) {
			if (other.dateRec != null)
				return false;
		} else if (!dateRec.equals(other.dateRec))
			return false;
		if (dateT == null) {
			if (other.dateT != null)
				return false;
		} else if (!dateT.equals(other.dateT))
			return false;
		if (etat != other.etat)
			return false;
		if (idRec != other.idRec)
			return false;
		if (sujetRec == null) {
			if (other.sujetRec != null)
				return false;
		} else if (!sujetRec.equals(other.sujetRec))
			return false;
		return true;
	}

	public Reclamation(int idRec, String sujetRec, String contenuRec, Date dateRec, Date dateT, int etat) {
		super();
		this.idRec = idRec;
		this.sujetRec = sujetRec;
		ContenuRec = contenuRec;
		this.dateRec = dateRec;
		this.dateT = dateT;
		this.etat = etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}
	
}
