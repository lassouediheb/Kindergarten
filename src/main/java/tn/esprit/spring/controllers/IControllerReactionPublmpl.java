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

import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.ReactionPub;
import tn.esprit.spring.entity.TypeReaction;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.PublicationRepository;
import tn.esprit.spring.repository.ReactionPubRepository;
import tn.esprit.spring.services.ReactionPubService;

@Scope(value = "session") 
@Controller(value = "reactionPubController") 
@ELBeanName(value = "reactionPubController") 
@Join(path = "/publication", to = "/acceuil.jsf")
public class IControllerReactionPublmpl {
	@Autowired
	ReactionPubService reactionPubService;
	@Autowired
	PublicationRepository publicationRepository;
	@Autowired
	ReactionPubRepository reactionPubRepository;
	private TypeReaction typeReaction;
	private Date dateReactionPub;
	private User user ;
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	private User authenticatedUser;
	public User getAuthenticatedUser() {
		return authenticatedUser;
	}
	public void setAuthenticatedUser(User authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}

	private Publication publication;
	private String pubContenu;
	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	public String getPubContenu() {
		return pubContenu;
	}
	public void setPubContenu(String pubContenu) {
		this.pubContenu = pubContenu;
	}
	public Date getDateReactionPub() {
		return dateReactionPub;
	}
	public void setDateReactionPub(Date dateReactionPub) {
		this.dateReactionPub = dateReactionPub;
	}
    public TypeReaction getTypeReaction() {
		return typeReaction;
	}
	public void setTypeReaction(TypeReaction typeReaction) {
		this.typeReaction = typeReaction;
	}
	public void addReactionPub(Publication publication,User user) {
		reactionPubService.addReactionPub(new ReactionPub(typeReaction,new Date(), publication,user));

	}
	public TypeReaction[] getTypeReactions() { return TypeReaction.values(); }
	
	public void removeReactionPub(String id)
	{
	reactionPubService.deleteReactionPub(id);}
	
	public void setReactionPubs(List<ReactionPub> reactionPubs) {
		this.reactionPubs = reactionPubs;
	}
	
	private List<ReactionPub> reactionPubs; 
	
	public List<ReactionPub> getReactionPubs() {
		reactionPubs = reactionPubService.getAllReactionPubs();
	return reactionPubs;
	}


	public List<ReactionPub> getReactionPubids() {
		return reactionPubids;
	}
	public void setReactionPubids(List<ReactionPub> reactionPubids) {
		this.reactionPubids = reactionPubids;
	}

	private long reactionPubIdToBeUpdated;
	
	
	public void displayReactionPub(ReactionPub rp , Publication pub )
	{
    this.setPublication(pub);
	this.setReactionPubIdToBeUpdated(rp.getId());
	this.setTypeReaction(rp.getTypeReaction());

}

	public void updateReactionPub(Publication publication,User user ) {
		reactionPubService.updateReactionPub(new ReactionPub(reactionPubIdToBeUpdated,typeReaction,new Date(),publication,user));

}
	public long getReactionPubIdToBeUpdated() {
		return reactionPubIdToBeUpdated;
	}
	public void setReactionPubIdToBeUpdated(long reactionPubIdToBeUpdated) {
		this.reactionPubIdToBeUpdated = reactionPubIdToBeUpdated;
	}
	public int getNombreReactionPub(long id ) {
		return reactionPubRepository.countReac(id);
	}
	public int getNombreReactionPubtype(long id ,TypeReaction typereaction) {
		return reactionPubRepository.countReact(id , typereaction);
	}
	private List<ReactionPub> reactionPubids;
	
	public List<ReactionPub> getAllReactionPubByIdpublication(long publicationId) {
		 reactionPubids= reactionPubRepository.getAllReactionPubByIdpublication(publicationId);
		 return  reactionPubids;
		
	}
	
	public List<ReactionPub> getReactionPubidetidusers() {
		return reactionPubidetidusers;
	}
	public void setReactionPubidetidusers(List<ReactionPub> reactionPubidetidusers) {
		this.reactionPubidetidusers = reactionPubidetidusers;
	}

	private List<ReactionPub> reactionPubidetidusers;
	public List<ReactionPub> getAllReactionPubByIdpublicationetuser(long publicationId , long iduser) {
		reactionPubidetidusers= reactionPubRepository.getAllReactionPubByIdpublicationetuser(publicationId , iduser);
		 return  reactionPubidetidusers;
		
	}
	private long publicationId;
	public long getPublicationId() {
		return publicationId;
	}
	public void setPublicationId(long publicationId) {
		this.publicationId = publicationId;
	}
	public String reactionPub(Publication pub ) 
	{ 	
		this.setPublication(pub);
		this.setPublicationId(pub.getId());
	return "reactionPub.xhtml?faces-redirect=true"; 
	}
	public String reactionPub12(Publication pub ) 
	{ 	
		this.setPublication(pub);
		this.setPublicationId(pub.getId());
	return "reactionPubjardin.xhtml?faces-redirect=true"; 
	}
}
