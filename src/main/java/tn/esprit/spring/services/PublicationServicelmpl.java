package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.ReactionPub;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.PublicationRepository;
import tn.esprit.spring.repository.ReactionPubRepository;
import tn.esprit.spring.repository.UserRepository;;

@Service
public class PublicationServicelmpl implements PublicationService {
	@Autowired
	PublicationRepository publicationRepository;
	@Autowired
	ReactionPubRepository reactionPubRepository;
	@Autowired
	UserRepository userRepository;
	private static final Logger L = LogManager.getLogger(PublicationServicelmpl.class);

	@Override
	public List<Publication> retrieveAllPublications() {
   List<Publication> publications = (List<Publication>) publicationRepository.findAll();
		
		for (Publication publication : publications){
			L.info("publication +++ :" + publication);
		}
		return publications;
	}

	@Override
	public Publication addPublication(Publication p) {
		
		Publication publication =publicationRepository.save(p);
		return publication;
	}

	@Override
	public void deletePublication(String id) {
		publicationRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Publication updatePublication(Publication p) {
		Publication publication =publicationRepository.save(p);
		return publication;
	}

	@Override
	public Publication retrievePublication(String id) {
		return	publicationRepository.findById(Long.parseLong(id)).orElse(null);
	}
	@Override
	public List<Publication> getAllPublications() {
	return (List<Publication>) publicationRepository.findAll();
	}
	public int getNombrepublication(long userid)
	{	
		
		User user = userRepository.findById(userid).get();
		return publicationRepository.countpub( userid);
	}
	 
	
	public List<Publication> getAllpublicationByIduser(long id) {
		return publicationRepository.getAllpublicationByIduser(id);
	}
	

}
