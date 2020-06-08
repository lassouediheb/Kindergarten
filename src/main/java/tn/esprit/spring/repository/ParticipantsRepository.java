package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Evenements;
import tn.esprit.spring.entity.Participants;

@Repository
public interface ParticipantsRepository extends CrudRepository<Participants, Long> {
	@Query("SELECT p FROM Participants p where p.evenements.idEvent=?1")
	 public List<Participants> getAllParticipantsByIdEvent(long idEvent);
	
	@Query("SELECT count(p) FROM Participants p where p.evenements.idEvent=?1")
	 public int nbParticip(long idEvent);
	
	@Query("SELECT p FROM Participants p where p.mailParticip=?1 AND p.evenements.idEvent=?1")
	 public Participants getParticipByMailEvent(String mailParticip,long idEvent);

}
