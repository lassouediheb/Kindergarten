package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Bus;


@Repository
public interface BusRepository extends CrudRepository<Bus, Long>{
	
	
	@Query("SELECT count(*) FROM Bus")
    public int countBus();
	

	Optional<Bus> findBymatricule( long matricule );
}
