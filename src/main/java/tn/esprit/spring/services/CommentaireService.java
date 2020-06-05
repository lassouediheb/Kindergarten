package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Commentaire;;

public interface CommentaireService {
	List<Commentaire> retrieveAllCommentaires();
	Commentaire addCommentaire(Commentaire c);
	 void deleteCommentaire(String id);
	 Commentaire updateCommentaire(Commentaire c);
	 Commentaire retrieveCommentaire(String id);
	 public List<Commentaire> getAllCommentaires();
	 public List<Commentaire> getAllcommentaireByIduseretpublication(long id,long iduser);
	 public List<Commentaire> getAllCommentairebByIdpublication(long id);
	 public int getNombrecommentairebyidpub(long id );
	 public List<Commentaire> getAllCommentairebByIduser(long id);
	 
}
