package tn.esprit.spring.controllers;


import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.ReactionPub;
import tn.esprit.spring.entity.TypeReaction;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.PublicationRepository;
import tn.esprit.spring.services.PublicationService;


@Scope(value = "session") 
@Controller(value = "publicationController") 
@ELBeanName(value = "publicationController") 
@Join(path = "/publication", to = "/Publication.jsf") 
public class IControllerPublicationlmpl {
	@Autowired
	PublicationService publicationService;
	@Autowired
	PublicationRepository publicationRepository;
	private long id ; 
	private long gg ; 
	public long getGg() {
		return gg;
	}

	public void setGg(long gg) {
		this.gg = gg;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}
	private String pubContenu;
	private Date datePublication;
	
    private User user ;
	private long authenticatedUser;

	public PublicationService getPublicationService() {
		return publicationService;}
		
	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}
	public Date getDatePublication() {
		return datePublication;
	}
	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}
	private Publication publication;
	
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	
	public void addPublication(User user) {
		publicationService.addPublication(new Publication(pubContenu,new Date(),user));

}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public long getAuthenticatedUser() {
		return authenticatedUser;
	}

	public void setAuthenticatedUser(long authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}

	public String getPubContenu() {
		return pubContenu;
	}
	public void setPubContenu(String pubContenu) {
		this.pubContenu = pubContenu;
	}
	
	private List<Publication> publications; 

	public List<Publication> getPublications() {
		publications = publicationService.getAllPublications();
	return publications;
	}
	
	
	public void removePublication(String id)
	{
	publicationService.deletePublication(id);}
	
	
	public long getPublicationIdToBeUpdated() {
		return publicationIdToBeUpdated;
	}

	public void setPublicationIdToBeUpdated(long publicationIdToBeUpdated) {
		this.publicationIdToBeUpdated = publicationIdToBeUpdated;
	}
	private long publicationIdToBeUpdated;
	
	
	public void displayPublication(Publication pub)
	{
	this.setPubContenu(pub.getPubContenu());

	this.setPublicationIdToBeUpdated(pub.getId());
	
	

}
	public void displayPublication1(Publication pub)
	{
	this.setPubContenu(pub.getPubContenu());

	this.setPublicationIdToBeUpdated(pub.getId());
	this.setPublication(pub);
	
}


	public void updatePublication(User user) {
		publicationService.updatePublication(new Publication(publicationIdToBeUpdated,pubContenu,new Date(),user));

}
	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public List<Publication> getPubiduser() {
		return pubiduser;
	}

	public void setPubiduser(List<Publication> pubiduser) {
		this.pubiduser = pubiduser;
	}
	private List<Publication> pubiduser;
	

	public List<Publication> getAllpublicationByIduser(long id) {
		pubiduser= publicationRepository.getAllpublicationByIduser(id);
		 return  pubiduser;
			
}
	//////////////////////////////////////////////

    private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void upload() {
        if (file != null) {
            FacesMessage message = new FacesMessage("Successful", file.getFileName()+ " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
     
     
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    
    }
}