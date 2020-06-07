package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Planning;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.EnfantRepository;
import tn.esprit.spring.repository.PlanningRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
@Service
public class PlanningServiceImpl implements PlanningSerivce {
	@Autowired
	PlanningRepository planningrepo;
	
	@Autowired
	EnfantRepository erepo;
	
	
	
	@Override
	public int AddPlanning(Planning p) {
		planningrepo.save(p);
		return 1;
	}

	

	@Override
	public void DeletePlanning(int id) {
		Planning planning =  planningrepo.findById(id).get();
		planningrepo.delete(planning);
		
		
		}

	@Override
	public Planning updatePlannig(Planning p) {
		 planningrepo.save(p);
		 return p;
	}

	@Override
	public List<Planning> GetPlByDate(Date date) {
		return planningrepo.GetPlByDate(date);
		
	}





	@Override
	public String EnvoiPlanning() {	
		return null;
		
		
	}



	/*@Override
	public List<Parent> parents(Long id) {
	  return erepo.parents(id);
	}*/
	@Override
	public List<Planning> Getallplan() {
		return planningrepo.findAll();
		
	}


}
