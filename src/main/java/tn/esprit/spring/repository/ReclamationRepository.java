package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.User;


@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation,Integer> {
	@Query("SELECT count(*) FROM Reclamation")
    public int countreclamation();
	
	List<Reclamation> findBySujetRecLike(String sujetRec);
	List<Reclamation> findBySujetRecLikeOrderByDateRecDesc (String sujetRec);
     List<Reclamation> findByUser(User user);
	@Query("SELECT DATEDIFF(datet,date_rec) FROM Reclamation WHERE etat=1")
     List <Number>dateDiff();
	
}
