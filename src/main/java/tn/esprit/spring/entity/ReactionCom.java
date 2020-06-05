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
@Table(name ="ReactionCom")
public class ReactionCom implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="REACTIONCOM_ID")
	
	private Long id;
	
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public ReactionCom(Long id, TypeReaction typeReaction, Date dateReactionCom, Commentaire commentaire, User user) {
		super();
		this.id = id;
		this.typeReaction = typeReaction;
		this.dateReactionCom = dateReactionCom;
		this.commentaire = commentaire;
		this.user = user;
	}



	public ReactionCom( TypeReaction typeReaction, Date dateReactionCom, Commentaire commentaire,User user) {
		super();
		
		this.typeReaction = typeReaction;
		this.dateReactionCom = dateReactionCom;
		this.commentaire = commentaire;
		this.user = user;
	}



	public ReactionCom() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public TypeReaction getTypeReaction() {
		return typeReaction;
	}



	public void setTypeReaction(TypeReaction typeReaction) {
		this.typeReaction = typeReaction;
	}



	public Date getDateReactionCom() {
		return dateReactionCom;
	}



	public void setDateReactionCom(Date dateReactionCom) {
		this.dateReactionCom = dateReactionCom;
	}



	public Commentaire getCommentaire() {
		return commentaire;
	}



	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Enumerated(EnumType.STRING)
	TypeReaction typeReaction;
	
	@Temporal(TemporalType.DATE)
	private Date dateReactionCom;



	@ManyToOne
	Commentaire commentaire;
	@ManyToOne
	User user;
	  	
}
