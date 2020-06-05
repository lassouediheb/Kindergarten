package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.ReactionPub;
import tn.esprit.spring.entity.TypeReaction;

public interface ReactionPubRepository extends CrudRepository<ReactionPub,Long>{
	
	@Query("SELECT count(r) FROM ReactionPub r where r.publication.id=?1")
    public int countReac(long id);
	@Query("SELECT  count(r) FROM ReactionPub r where r.typeReaction=?1 And r.publication.id=?1")
    public int countReact(long id, TypeReaction typereaction);
	 @Query("SELECT r FROM ReactionPub r where r.publication.id=?1")
	 public List<ReactionPub> getAllReactionPubByIdpublication(long id);
	 @Query("SELECT r FROM ReactionPub r where r.publication.id=:id And r.user.id=:iduser")
	 public List<ReactionPub> getAllReactionPubByIdpublicationetuser(@Param("id")long id,@Param("iduser")long iduser);
}
