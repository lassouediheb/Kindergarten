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
	
	@Query("SELECT COUNT(*) FROM Reclamation WHERE Month(date_rec)= ?1")
    public int countmonth(int m);
	
	@Query("SELECT COUNT(*) FROM Reclamation WHERE Month(datet)= ?1")
    public int Tmonth(int m);
	
	
	@Query(value = "SELECT u.d_type FROM  users u where u.id =?1" , nativeQuery= true)
    public String type(long id);
	
	
	@Query("SELECT j.numJ FROM Jardin j where j.id =?1")
    public String numj(long id);
	
	@Query("SELECT p.numP FROM Parent p where id =?1")
    public String nump(long id);
	
	
}
