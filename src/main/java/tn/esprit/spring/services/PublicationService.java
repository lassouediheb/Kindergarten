package tn.esprit.spring.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.User;

public interface PublicationService {
	List<Publication> retrieveAllPublications();
	public Publication addPublication(Publication p );
	 void deletePublication(String id);
	 Publication updatePublication(Publication p);
	 Publication retrievePublication(String id);
	 public List<Publication> getAllPublications() ;
	 public int getNombrepublication(long userid );
	 public List<Publication> getAllpublicationByIduser(long id) ;
	 public List<Publication> listAll(String keyword);
}
