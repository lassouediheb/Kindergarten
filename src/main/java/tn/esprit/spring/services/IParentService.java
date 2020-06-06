package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Parent;

public interface IParentService {

	int addParent(Parent p);

	List<Parent> retrieveAllParent();

	Parent updateParent(Parent p);

	void deleteParent(String id);
	Parent retrieveParent(String id);

}
