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
	
	@Query(value="SELECT r.m FROM (SELECT count(p.mail_particip) c , p.mail_particip m FROM t_participant p, t_evenement e WHERE p.evenements_id_event=e.id_event AND e.jardin_id=?1 GROUP BY p.mail_particip) r WHERE r.c>9", nativeQuery=true)
		public List<String> nbFidelite(long id);
	
}
