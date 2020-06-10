package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Evenements;

public interface EvenementsRepository extends CrudRepository<Evenements, Long>{
	
	@Query("SELECT e FROM Evenements e where e.idEvent=?1")
		public Evenements getEvenementByIdEvent(long idEvent);
	
	@Query("SELECT e FROM Evenements e where e.jardin.id=?1")
		public List<Evenements> getAllEventByIdJardin(long id) ;
	
	@Query("SELECT e FROM Evenements e where e.idEvent=?1")
		public Evenements getEventById(long idEvent);
	
	@Query("SELECT e FROM Evenements e WHERE e.nomE LIKE %?1%"  + " OR e.jardin.nomJ LIKE %?1%")          
		public List<Evenements> search(String keyword);


	


}
