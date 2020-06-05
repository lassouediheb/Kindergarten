package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.ReactionPub;
import tn.esprit.spring.entity.TypeReaction;

public interface ReactionPubService {
	List<ReactionPub> retrieveAllReactionPubs();
	ReactionPub addReactionPub(ReactionPub rp);
	 void deleteReactionPub(String id);
	 ReactionPub updateReactionPub(ReactionPub rp);
	 ReactionPub retrieveReactionPub(String id);
	 public List<ReactionPub> getAllReactionPubs();
	 public int getNombreReactionPub(long id);
	 public int getNombreReactionPubtype(long id, TypeReaction typereaction);
	 public List<ReactionPub> getAllReactionPubByIdpublication(long id) ;
	 public List<ReactionPub> getAllReactionPubByIdpublicationetuser(long id , long iduser);
	 
	


}
