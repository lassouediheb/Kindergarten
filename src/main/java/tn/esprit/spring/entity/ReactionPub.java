package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="ReactionPub")
public class ReactionPub implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="REACTIONPUB_ID")
	
	private Long id;
	
	@Enumerated(EnumType.STRING)
	TypeReaction typeReaction;
	
	@Temporal(TemporalType.DATE)
	private Date dateReactionPub;


	public ReactionPub(Long id, TypeReaction typeReaction, Date dateReactionPub, Publication publication, User user) {
		super();
		this.id = id;
		this.typeReaction = typeReaction;
		this.dateReactionPub = dateReactionPub;
		this.publication = publication;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateReactionPub() {
		return dateReactionPub;
	}

	public void setDateReactionPub(Date dateReactionPub) {
		this.dateReactionPub = dateReactionPub;
	}

	public ReactionPub(TypeReaction typeReaction ,Date dateReactionPub , Publication publication ,User user) {
		super();
		
		this.typeReaction = typeReaction;
		this.dateReactionPub = dateReactionPub;
		this.publication = publication;
		this.user = user;
	}

	public TypeReaction getTypeReaction() {
		return typeReaction;
	}

	public void setTypeReaction(TypeReaction typeReaction) {
		this.typeReaction = typeReaction;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public ReactionPub() {
		super();
		// TODO Auto-generated constructor stub
	}



	@ManyToOne
	Publication publication;
	@ManyToOne
	User user;
	  	
}
