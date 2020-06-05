package tn.esprit.spring.controllers;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.DispatcherType;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.ReactionCom;
import tn.esprit.spring.entity.ReactionPub;
import tn.esprit.spring.entity.TypeReaction;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.CommentaireRepository;
import tn.esprit.spring.repository.ReactionComRepository;
import tn.esprit.spring.services.ReactionComService;


@Scope(value = "session") 
@Controller(value = "reactionComController") 
@ELBeanName(value = "reactionComController") 
@Join(path = "/publication", to = "/acceuil.jsf")
public class IControllerReactionComlmpl {
	@Autowired
	ReactionComService reactionComService;
	@Autowired
	CommentaireRepository  commentaireRepository;
	@Autowired
	ReactionComRepository reactionComRepository;
	private TypeReaction typeReaction;
	private Date dateReactionCom;
	private List<ReactionCom> reactionComs;
	private User user;
	private String firstName;
	private Commentaire commentaire;
	private User authenticatedUser;
	
	public void addReactionCom(Commentaire commentaire,User user) {
		reactionComService.addReactionCom(new ReactionCom(typeReaction,new Date(), commentaire ,user));

	}
	public TypeReaction[] getTypeReactions() { return TypeReaction.values(); }
	
	public void removeReactionCom(String id)
	{
	reactionComService.deleteReactionCom(id);}
	
 
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
	public void setReactionComs(List<ReactionCom> reactionComs) {
		this.reactionComs = reactionComs;
	}
	public List<ReactionCom> getReactionComs() {
		reactionComs = reactionComService.getAllReactionComs();
	return reactionComs;
	}
	private long reactionComIdToBeUpdated;
	
	
	public void displayReactionCom(ReactionCom rc , Commentaire com )
	{
    this.setCommentaire(com);
	this.setReactionComIdToBeUpdated(rc.getId());
	this.setTypeReaction(rc.getTypeReaction());

}
	public void updateReactionCom(Commentaire commentaire,User user ) {
		reactionComService.updateReactionCom(new ReactionCom(reactionComIdToBeUpdated,typeReaction,new Date(),commentaire,user));

}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Commentaire getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}
	public User getAuthenticatedUser() {
		return authenticatedUser;
	}
	public void setAuthenticatedUser(User authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}
	public long getReactionComIdToBeUpdated() {
		return reactionComIdToBeUpdated;
	}
	public void setReactionComIdToBeUpdated(long reactionComIdToBeUpdated) {
		this.reactionComIdToBeUpdated = reactionComIdToBeUpdated;
	}
	
	public int getNombreReactionCom(long id ) {
		Commentaire commentaire= commentaireRepository.findById(id).get();
		return reactionComRepository.countReacC(id);
	}
private List<ReactionCom> reactionComids;
	
	public List<ReactionCom> getAllReactionPubByIdcommentaire(long commentaireId) {
		 reactionComids= reactionComRepository.getAllReactionPubByIdcommentaire(commentaireId);
		 return  reactionComids;
		
	}
	private long commentaireId;

	public String reactionCom(Commentaire com ) 
	{ 	
		this.setCommentaire(com);
		this.setCommentaireId(com.getId());
	return "/pages/jardin/reactionCom.xhtml?faces-redirect=true"; 
	}
	public List<ReactionCom> getReactionComids() {
		return reactionComids;
	}
	public void setReactionComids(List<ReactionCom> reactionComids) {
		this.reactionComids = reactionComids;
	}
	public long getCommentaireId() {
		return commentaireId;
	}
	public void setCommentaireId(long commentaireId) {
		this.commentaireId = commentaireId;
	}
	private List<ReactionCom> reactionComidetidusers;
	public List<ReactionCom> getAllReactionComByIdcommentaireetuser(long commentaireId , long iduser) {
		reactionComidetidusers= reactionComRepository.getAllReactionComByIdcommentaireetuser(commentaireId , iduser);
		 return  reactionComidetidusers;
		
	}
	public List<ReactionCom> getReactionComidetidusers() {
		return reactionComidetidusers;
	}
	public void setReactionComidetidusers(List<ReactionCom> reactionComidetidusers) {
		this.reactionComidetidusers = reactionComidetidusers;
	}
}
