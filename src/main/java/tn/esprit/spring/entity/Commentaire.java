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
@Table(name ="CommentairePub")
public class Commentaire implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="COM_ID")
	
	private Long id;

	
	@Column(name ="ComContenu")
	 private String ComContenu;
	
	@Temporal(TemporalType.DATE)
	private Date dateCommentaire;
	
	
	public Commentaire(Long id, String comContenu, Date dateCommentaire, Publication publication, User user) {
		super();
		this.id = id;
		ComContenu = comContenu;
		this.dateCommentaire = dateCommentaire;
		this.publication = publication;
		this.user = user;
		
	}


	public Set<ReactionCom> getReactionCom() {
		return reactionCom;
	}


	public void setReactionCom(Set<ReactionCom> reactionCom) {
		this.reactionCom = reactionCom;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Commentaire( String comContenu, Date dateCommentaire, Publication publication, User user) {
		super();
		
		ComContenu = comContenu;
		this.dateCommentaire = dateCommentaire;
		this.publication = publication;
		this.user = user;
	}


	@ManyToOne
	Publication publication;


	public Commentaire(String comContenu, Date dateCommentaire) {
		super();
		
		ComContenu = comContenu;
		this.dateCommentaire = dateCommentaire;
		
	}


	public Publication getPublication() {
		return publication;
	}


	public void setPublication(Publication publication) {
		this.publication = publication;
	}


	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComContenu() {
		return ComContenu;
	}

	public void setComContenu(String comContenu) {
		ComContenu = comContenu;
	}

	public Date getDateCommentaire() {
		return dateCommentaire;
	}

	public void setDateCommentaire(Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="commentaire") 
	private Set<ReactionCom> reactionCom;
	@ManyToOne
	User user;
	
}