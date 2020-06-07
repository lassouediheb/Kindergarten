package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.entity.Evenements;
import tn.esprit.spring.entity.Participants;

public interface EvenementsRepository extends CrudRepository<Evenements, Long>{
	
	@Query("SELECT e FROM Evenements e where e.idEvent=?1")
	 public Evenements getEvenementByIdEvent(long idEvent);
	
	@Query("SELECT e FROM Evenements e where e.jardin.id=?1")
	 public List<Evenements> getAllEventByIdJardin(long id) ;
	


}
