package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Reclamation;


@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation,Integer> {
	@Query("SELECT count(*) FROM Reclamation")
    public int countreclamation();
	
	List<Reclamation> findBySujetRecLike(String sujetRec);
	List<Reclamation> findBySujetRecLikeOrderByDateRecDesc (String sujetRec);
	
	@Query("SELECT sujetRec,DATEDIFF(datet,date_rec) FROM Reclamation WHERE etat=1")
     List <String>dateDiff();
}
