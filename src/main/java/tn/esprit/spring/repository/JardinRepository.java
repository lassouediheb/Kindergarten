package tn.esprit.spring.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Jardin;

public interface JardinRepository extends CrudRepository<Jardin, Long>{
	
	@Query("SELECT j FROM Jardin j where j.id=?1")
	 public Jardin getJardById(long id);

}
