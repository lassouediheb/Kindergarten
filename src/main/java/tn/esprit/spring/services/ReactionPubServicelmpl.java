package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.ReactionPub;
import tn.esprit.spring.entity.TypeReaction;
import tn.esprit.spring.repository.PublicationRepository;
import tn.esprit.spring.repository.ReactionPubRepository;

@Service
public class ReactionPubServicelmpl implements ReactionPubService {
	@Autowired
	ReactionPubRepository reactionPubRepository;
	@Autowired
	PublicationRepository publicationRepository;
	@Autowired
	ReactionPubService reactionPubService;
	
	private static final Logger L = LogManager.getLogger(ReactionPubServicelmpl.class);
	
	@Override
	public List<ReactionPub> retrieveAllReactionPubs() {
    List<ReactionPub> reactionPubs = (List<ReactionPub>) reactionPubRepository.findAll();
		
		for (ReactionPub reactionPub : reactionPubs){
			L.info("reactionPub +++ :" + reactionPub);
		}
		return reactionPubs;
	}

	@Override
	public ReactionPub addReactionPub(ReactionPub rp) {
		ReactionPub reactionPub =reactionPubRepository.save(rp);
		return reactionPub;
	}

	@Override
	public void deleteReactionPub(String id) {
		reactionPubRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public ReactionPub updateReactionPub(ReactionPub rp) {
		ReactionPub reactionPub =reactionPubRepository.save(rp);
		return reactionPub;
	}

	@Override
	public ReactionPub retrieveReactionPub(String id) {
		return	reactionPubRepository.findById(Long.parseLong(id)).orElse(null);
	}
	

	@Override
	public List<ReactionPub> getAllReactionPubs() {
	return (List<ReactionPub>) reactionPubRepository.findAll();
	}
	
	public int getNombreReactionPub(long id ) {
		Publication publication= publicationRepository.findById(id).get();
		return reactionPubRepository.countReac(id);
	}
	public int getNombreReactionPubtype(long id , TypeReaction typereaction) {
		
		return reactionPubRepository.countReact(id,typereaction);
	}
	
	public List<ReactionPub> getAllReactionPubByIdpublication(long id) {
		return reactionPubRepository.getAllReactionPubByIdpublication(id);
	}
	public List<ReactionPub> getAllReactionPubByIdpublicationetuser(long id , long iduser) {
		return reactionPubRepository.getAllReactionPubByIdpublicationetuser(id, iduser);
	}

}
