package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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
	
	@Query("SELECT COUNT(*) FROM Reclamation WHERE Month(date_rec)= ?1")
    public int countmonth(int m);
	
	@Query("SELECT COUNT(*) FROM Reclamation WHERE Month(datet)= ?1")
    public int Tmonth(int m);
	
//	
//	@Query("SELECT u.dtype FROM Role u where u.id =?1")
//    public String type(int id);
	
	
//	@Query("SELECT j.num_j FROM j.T_JARDIN where j.id =?1")
//    public String numj(int id);
//	
//	@Query("SELECT p.num_p FROM T_PARENT where id =?1")
//    public String nump(int id);
	
	
}
