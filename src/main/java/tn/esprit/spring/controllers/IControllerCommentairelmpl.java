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
import tn.esprit.spring.entity.ReactionPub;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.CommentaireRepository;
import tn.esprit.spring.services.CommentaireService;




@Scope(value = "session") 
@Controller(value = "commentaireController") 
@ELBeanName(value = "commentaireController") 
@Join(path = "/publication", to = "/acceuil.jsf")
public class IControllerCommentairelmpl {
	@Autowired
	CommentaireRepository commentaireRepository;

public String getComContenu() {
		return comContenu;
	}
	public void setComContenu(String comContenu) {
		this.comContenu = comContenu;
	}

	public Date getDateCommentaire() {
		return dateCommentaire;
	}
	public void setDateCommentaire(Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}
	public Commentaire getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}

@Autowired
CommentaireService commentaireService;
public Publication getPublication() {
	return publication;
}
public void setPublication(Publication publication) {
	this.publication = publication;
}
private String comContenu;
private Date dateCommentaire;
private Commentaire commentaire;
private Publication publication;
private String pubContenu;
private String firstName;
private User user;
private User authenticatedUser;
public User getAuthenticatedUser() {
	return authenticatedUser;
}
public void setAuthenticatedUser(User authenticatedUser) {
	this.authenticatedUser = authenticatedUser;
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
public String getPubContenu() {
	return pubContenu;
}
public void setPubContenu(String pubContenu) {
	this.pubContenu = pubContenu;
}
public void addCommentaire(Publication publication, User user) {
	commentaireService.addCommentaire(new Commentaire(comContenu,new Date(),publication,user));

}

private List<Commentaire> commentaires; 

public void setCommentaires(List<Commentaire> commentaires) {
	this.commentaires = commentaires;
}
public List<Commentaire> getCommentaires() {
	commentaires = commentaireService.getAllCommentaires();
return commentaires;
}

public void removeCommentaire(String id)
{
commentaireService.deleteCommentaire(id);}

private long commentaireIdToBeUpdated;

public void displayCommentaire(Commentaire com, Publication pub)
{
	this.setPublication(pub);
    this.setCommentaireIdToBeUpdated(com.getId());
    this.setComContenu(com.getComContenu());
   

}
public void displayCommentaire1(Commentaire com)
{
	this.setCommentaire(com);
    this.setCommentaireIdToBeUpdated(com.getId());
    this.setComContenu(com.getComContenu());
   

}
public void updateCommentaire(Publication publication,User user) {
	commentaireService.updateCommentaire(new Commentaire(commentaireIdToBeUpdated,comContenu,new Date(),publication,user));

}
public long getCommentaireIdToBeUpdated() {
	return commentaireIdToBeUpdated;
}
public void setCommentaireIdToBeUpdated(long commentaireIdToBeUpdated) {
	this.commentaireIdToBeUpdated = commentaireIdToBeUpdated;
}
private List<Commentaire> comiduser;
public List<Commentaire> getComiduser() {
	return comiduser;
}
public void setComiduser(List<Commentaire> comiduser) {
	this.comiduser = comiduser;
}
public List<Commentaire> getAllcommentaireByIduseretpublication(long publicationcomId , long iduser) {
	comiduser= commentaireRepository.getAllcommentaireByIduseretpublication(publicationcomId,iduser);
	 return  comiduser;
		
}
public long getPublicationcomId() {
	return PublicationcomId;
}
public void setPublicationcomId(long publicationcomId) {
	PublicationcomId = publicationcomId;
}

private List<Commentaire> commentairebuidpubs;

public List<Commentaire> getAllCommentaireByIdpublication(long publicationId) {
	commentairebuidpubs= commentaireRepository.getAllCommentaireByIdpublication(publicationId);
	 return  commentairebuidpubs;
	
}
public List<Commentaire> getCommentairebuidpubs() {
	return commentairebuidpubs;
}
public void setCommentairebuidpubs(List<Commentaire> commentairebuidpubs) {
	this.commentairebuidpubs = commentairebuidpubs;
}
private long PublicationcomId ;

public String reactionPub(Publication pub ) 
{ 	
	this.setPublication(pub);
	this.setPublicationcomId(pub.getId());
return "/pages/jardin/commentaire.xhtml?faces-redirect=true"; 
}
public int getNombrecommentairebyidpub(long id ) {
	return commentaireRepository.countcom(id);
}
private List<Commentaire> commentairebuidusers;

public List<Commentaire> getAllCommentaireByIduser(long id) {
	commentairebuidusers= commentaireRepository.getAllCommentaireByIduser(id);
	 return  commentairebuidusers;
	
}
public List<Commentaire> getCommentairebuidusers() {
	return commentairebuidusers;
}
public void setCommentairebuidusers(List<Commentaire> commentairebuidusers) {
	this.commentairebuidusers = commentairebuidusers;
}


}
