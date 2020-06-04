package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Evenements;

public interface EvenementsRepository extends CrudRepository<Evenements, Long>{
	
	@Query("SELECT e FROM Evenements e where e.idEvent=?1")
	 public Evenements getEvenementByIdEvent(long idEvent);
	

}
