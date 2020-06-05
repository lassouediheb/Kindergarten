package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.ReactionCom;
import tn.esprit.spring.entity.ReactionPub;
import tn.esprit.spring.repository.CommentaireRepository;
import tn.esprit.spring.repository.ReactionComRepository;

@Service
public class ReactionComServicelmpl implements ReactionComService {
	
	@Autowired
	ReactionComRepository reactionComRepository;
	@Autowired
	CommentaireRepository commentaireRepository;

private static final Logger L = LogManager.getLogger(ReactionComServicelmpl.class);
	
	@Override
	public List<ReactionCom> retrieveAllReactionComs() {
    List<ReactionCom> reactionComs = (List<ReactionCom>) reactionComRepository.findAll();
		
		for (ReactionCom reactionCom : reactionComs){
			L.info("reactionCom +++ :" + reactionCom);
		}
		return reactionComs;
	}

	@Override
	public ReactionCom addReactionCom(ReactionCom rc) {
		ReactionCom reactionCom =reactionComRepository.save(rc);
		return reactionCom;
	}

	@Override
	public void deleteReactionCom(String id) {
		reactionComRepository.deleteById(Long.parseLong(id));
	}

	@Override
	public ReactionCom updateReactionCom(ReactionCom rc) {
		ReactionCom reactionCom =reactionComRepository.save(rc);
		return reactionCom;
	}

	@Override
	public ReactionCom retrieveReactionCom(String id) {
		return	reactionComRepository.findById(Long.parseLong(id)).orElse(null);
	}
	@Override
	public List<ReactionCom> getAllReactionComs() {
	return (List<ReactionCom>) reactionComRepository.findAll();
	}
	
	public int getNombreReactionCom(long id ) {
		Commentaire commentaire= commentaireRepository.findById(id).get();
		return reactionComRepository.countReacC(id);
	}
	public List<ReactionCom> getAllReactionComByIdcommentaire(long id) {
		return reactionComRepository.getAllReactionPubByIdcommentaire(id);
	}
	public List<ReactionCom> getAllReactionComByIdcommentaireetuser(long id , long iduser) {
		return reactionComRepository.getAllReactionComByIdcommentaireetuser(id, iduser);
	}
}
