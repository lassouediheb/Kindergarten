package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.ReactionCom;

public interface ReactionComService {
	List<ReactionCom> retrieveAllReactionComs();
	ReactionCom addReactionCom(ReactionCom rc);
	 void deleteReactionCom(String id);
	 ReactionCom updateReactionCom(ReactionCom rc);
	 ReactionCom retrieveReactionCom(String id);
	 public List<ReactionCom> getAllReactionComs();
	 public int getNombreReactionCom(long id ) ;
	 public List<ReactionCom> getAllReactionComByIdcommentaire(long id);
	 public List<ReactionCom> getAllReactionComByIdcommentaireetuser(long id , long iduser);
}
