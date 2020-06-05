package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Activités;


@Repository
public interface ActiviteRepository extends CrudRepository<Activités, Long>{
		
}