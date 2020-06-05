package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="Publication")
public class Publication implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public User getUser() {
		return user;
	}

    public void setUser(User user) {
		this.user = user;
	}
 

    public Publication(String pubContenu, Date datePublication ) {
		super();
		PubContenu = pubContenu;
		this.datePublication = datePublication;
		
	}

	public Publication(String pubContenu, Date datePublication, User user) {
		super();
		PubContenu = pubContenu;
		this.datePublication = datePublication;
		this.user = user;
	}

	public Publication(Long id, String pubContenu, Date datePublication, User user) {
		super();
		this.id = id;
		PubContenu = pubContenu;
		this.datePublication = datePublication;
		this.user = user;
	
	}

	public Publication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPubContenu() {
		return PubContenu;
	}

	public void setPubContenu(String pubContenu) {
		PubContenu = pubContenu;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="PUB_ID")
	
	private Long id;

	
	@Column(name ="PubContenu")
	 private String PubContenu;
	
	@Temporal(TemporalType.DATE)
	private Date datePublication;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="publication") 
	private Set<Commentaire> Commentaire;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="publication") 
	private Set<ReactionPub> reactionPub;
	
	@ManyToOne
	User user;
	
}
