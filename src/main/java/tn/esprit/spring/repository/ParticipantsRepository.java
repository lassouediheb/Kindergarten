package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.entity.Participants;

public interface ParticipantsRepository extends CrudRepository<Participants, Long> {
	
	@Query("SELECT p FROM Participants p where p.evenements.idEvent=?1")
	 public List<Participants> getAllParticipantsByIdEvent(long idEvent);
	 @Query("SELECT count(p) FROM Participants p where p.evenements.idEvent=?1")
	    public int nbPartcip(long idEvent);

}
