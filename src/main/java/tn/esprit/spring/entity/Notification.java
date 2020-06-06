package tn.esprit.spring.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Notification implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNotif; // Clé primaire
	private String TitreNotif;
	private String ContenNotif;
	
	
	public long getIdNotif() {
		return idNotif;
	}

	public void setIdNotif(int idNotif) {
		this.idNotif = idNotif;
	}

	public Notification() {

	}

	public Notification(int idNotif, String titreNotif, String contenNotif) {

		this.idNotif = idNotif;
		TitreNotif = titreNotif;
		ContenNotif = contenNotif;
	}

	@Override
	public String toString() {
		return "Notification [idNotif=" + idNotif + ", TitreNotif=" + TitreNotif + ", ContenNotif=" + ContenNotif + "]";
	}

	public String getTitreNotif() {
		return TitreNotif;
	}

	public void setTitreNotif(String titreNotif) {
		TitreNotif = titreNotif;
	}

	public String getContenNotif() {
		return ContenNotif;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ContenNotif == null) ? 0 : ContenNotif.hashCode());
		result = prime * result + ((TitreNotif == null) ? 0 : TitreNotif.hashCode());
		result = prime * result + (int) (idNotif ^ (idNotif >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notification other = (Notification) obj;
		if (ContenNotif == null) {
			if (other.ContenNotif != null)
				return false;
		} else if (!ContenNotif.equals(other.ContenNotif))
			return false;
		if (TitreNotif == null) {
			if (other.TitreNotif != null)
				return false;
		} else if (!TitreNotif.equals(other.TitreNotif))
			return false;
		if (idNotif != other.idNotif)
			return false;
		return true;
	}

	public void setContenNotif(String contenNotif) {
		ContenNotif = contenNotif;
	}
}
