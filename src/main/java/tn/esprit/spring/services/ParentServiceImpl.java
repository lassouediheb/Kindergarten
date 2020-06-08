package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.repository.ParentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ParentServiceImpl implements ParentService {
	@Autowired
	ParentRepository parentrepo;
	
	@Override
	public Parent AddParent(Parent p) {
		Parent parent =parentrepo.save(p);
		return parent;
	}

	@Override
	public Parent updateParent(Parent p) {
		Parent parent =parentrepo.save(p);
		return parent;
	}

	
	@Override
	public void DeleteParent(String id) {
		parentrepo.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Parent GetParentById(String id) {
		Parent parent =parentrepo.findById(Long.parseLong(id)).orElse(null);
		return parent;
			}

	@Override
	public List<Parent> AllParents() {
		return (List<Parent>) parentrepo.findAll(); 

	}

	
	
	}


