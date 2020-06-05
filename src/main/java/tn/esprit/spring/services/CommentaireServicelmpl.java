package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.ReactionPub;
import tn.esprit.spring.repository.CommentaireRepository;;

@Service
public class CommentaireServicelmpl implements CommentaireService {
	@Autowired
	CommentaireRepository commentaireRepository;
	
	private static final Logger L = LogManager.getLogger(CommentaireServicelmpl.class);

	@Override
	public List<Commentaire> retrieveAllCommentaires() {
List<Commentaire> commentaires = (List<Commentaire>) commentaireRepository.findAll();
		
		for (Commentaire commentaire : commentaires){
			L.info("commentaire +++ :" + commentaire);
		}
		return commentaires;
	}

	@Override
	public Commentaire addCommentaire(Commentaire c) {
		Commentaire commentaire =commentaireRepository.save(c);
		return commentaire;
	}

	@Override
	public void deleteCommentaire(String id) {
		commentaireRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Commentaire updateCommentaire(Commentaire c) {
		Commentaire commentaire =commentaireRepository.save(c);
		return commentaire;
	}

	@Override
	public Commentaire retrieveCommentaire(String id) {
		return	commentaireRepository.findById(Long.parseLong(id)).orElse(null);
	}
	
	@Override
	public List<Commentaire> getAllCommentaires() {
	return (List<Commentaire>) commentaireRepository.findAll();
	}
	public List<Commentaire> getAllcommentaireByIduseretpublication( long id,long iduser ) {
		return commentaireRepository.getAllcommentaireByIduseretpublication(id,iduser);
	}
	public List<Commentaire> getAllCommentairebByIdpublication(long id) {
		return commentaireRepository.getAllCommentaireByIdpublication(id);
	}
	public int getNombrecommentairebyidpub(long id ) {
		
		return commentaireRepository.countcom(id);
	}
	public List<Commentaire> getAllCommentairebByIduser(long id) {
		return commentaireRepository.getAllCommentaireByIduser(id);
	}
}
