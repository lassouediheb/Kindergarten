package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Planning;

import org.springframework.data.repository.query.Param;


public interface ParentService {
	public Parent AddParent(Parent p);
	public Parent updateParent(Parent p);
	public void DeleteParent(String id);
	Parent GetParentById(String id);
	List<Parent> AllParents();
	 
	

}
