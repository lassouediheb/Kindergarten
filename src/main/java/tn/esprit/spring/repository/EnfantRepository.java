package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Classe;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Parent;
@Repository
public interface EnfantRepository extends JpaRepository<Enfant, Long> {
	List<Enfant>  findByParent(Parent parent);
	@Query("select count(e) from Enfant e where e.classe=:co")
    int findsizeofclasse(@Param("co")Classe classe);
	@Query("SELECT e FROM Enfant e  where e.abonnée =1")
    public List<Enfant> GetEnfantabonnée();
	@Query("SELECT e.parent FROM Enfant e "
			+"JOIN e.parent u "
			+"WHERE e.id=:idenfant")
	public List<Parent> parents(@Param("idenfant")Long idenfant);


}
