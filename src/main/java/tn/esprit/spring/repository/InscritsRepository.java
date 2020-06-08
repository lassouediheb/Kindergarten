package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Inscrits;
import tn.esprit.spring.entity.Participants;

@Repository
public interface InscritsRepository extends CrudRepository<Inscrits, Long>{
	
	@Query("SELECT i FROM Inscrits i where i.bus.matricule=?1")
	 public List<Inscrits> getinscribybus(long matricule);
	
}
