package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.ReactionCom;
import tn.esprit.spring.entity.ReactionPub;

public interface ReactionComRepository extends CrudRepository<ReactionCom,Long>{
	@Query("SELECT count(rc) FROM ReactionCom rc where rc.commentaire.id=?1")
    public int countReacC(long id);
	 @Query("SELECT rc FROM ReactionCom rc where rc.commentaire.id=?1")
	 public List<ReactionCom> getAllReactionPubByIdcommentaire(long id);
	 @Query("SELECT rc FROM ReactionCom rc where rc.commentaire.id=:id And rc.user.id=:iduser")
	 public List<ReactionCom> getAllReactionComByIdcommentaireetuser(@Param("id")long id,@Param("iduser")long iduser);
}
