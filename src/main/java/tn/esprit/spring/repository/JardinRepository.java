package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Jardin;

public interface JardinRepository extends CrudRepository<Jardin, Long>{
	
	@Query("SELECT j FROM Jardin j where j.id=?1")
		public Jardin getJardById(long id);
	
	@Query("SELECT j FROM Jardin j WHERE j.nomJ LIKE %?1%" + " OR j.adresseJ LIKE %?1%")          
		public List<Jardin> search(String keyword);


}
