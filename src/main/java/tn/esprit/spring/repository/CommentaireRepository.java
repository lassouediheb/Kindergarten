package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.ReactionPub;

public interface CommentaireRepository extends CrudRepository<Commentaire,Long> {
	 @Query("SELECT c FROM Commentaire c where c.publication.id=:id And c.user.id=:iduser")
	 public List<Commentaire> getAllcommentaireByIduseretpublication(@Param("id")long id,@Param("iduser")long iduser) ;
	 @Query("SELECT c FROM Commentaire c where c.publication.id=?1")
	 public List<Commentaire> getAllCommentaireByIdpublication(long id);
	 @Query("SELECT count(c) FROM Commentaire c where c.publication.id=?1")
	    public int countcom(long id);
	 @Query("SELECT c FROM Commentaire c where c.user.id=?1")
	 public List<Commentaire> getAllCommentaireByIduser(long id);
}
