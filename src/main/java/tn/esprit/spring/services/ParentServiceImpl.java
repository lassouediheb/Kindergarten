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
	public int AddParent(Parent p) {
		Parent parent =parentrepo.save(p);
		return 0;
	}

	@Override
	public Parent updateParent(Parent p) {
		Parent parent =parentrepo.save(p);
		return p;
	}

	@Override
	public void DeleteParent(int id) {
		parentrepo.deleteById(id);
		
	}

	@Override
	public Parent GetParentById(int id) {
		Parent parent =parentrepo.findById((id)).orElse(null);
		return parent;
			}

	@Override
	public List<Parent> AllParents() {
		return (List<Parent>) parentrepo.findAll(); 

	}

	
	
	}


