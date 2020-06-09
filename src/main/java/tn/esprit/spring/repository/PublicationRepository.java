package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.ReactionPub;
import tn.esprit.spring.entity.User;


public interface PublicationRepository extends CrudRepository<Publication,Long> {
	@Query("SELECT  count(p) FROM Publication p where p.user.id=?1 ")
    public int countpub(long userid);
	 @Query("SELECT p FROM Publication p where p.user.id=?1")
	 public List<Publication> getAllpublicationByIduser(long id) ;
	  @Query("SELECT p FROM Publication p WHERE p.PubContenu LIKE %?1%"
	            + " OR p.user.username LIKE %?1%")          
	  public List<Publication> search(String keyword);
	
}
