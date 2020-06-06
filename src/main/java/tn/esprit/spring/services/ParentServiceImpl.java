package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import tn.esprit.spring.entity.Classe;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.entity.Niveau;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.repository.ClasseRepository;
import tn.esprit.spring.repository.EnfantRepository;
import tn.esprit.spring.repository.JardinRepository;
import tn.esprit.spring.repository.ParentRepository;
import tn.esprit.spring.repository.UserRepository;



@Service
@Transactional
public class ParentServiceImpl implements IParentService {
	@Autowired
	ParentRepository pr;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ClasseRepository classeRepository;
	@Autowired
	JardinRepository jardinRepository;
	@Autowired
	EnfantRepository enfantRepository;

	@Override
	public int addParent(tn.esprit.spring.entity.Parent p) {
		Parent parent =pr.save( p);
				return 1;
	}

	@Override
	public List<tn.esprit.spring.entity.Parent> retrieveAllParent() {
List<Parent> parent = (List<Parent>) pr.findAll();
		
		for (Parent p : parent){
		}
		return parent;
	}

	@Override
	public tn.esprit.spring.entity.Parent updateParent(tn.esprit.spring.entity.Parent p) {
		Parent parent =pr.save( p);
		return p;

	}

	@Override
	public void deleteParent(String id) {
		pr.deleteById(Long.parseLong(id));
		
	}
	
	
	@Override
	public Parent retrieveParent(String id) {
		Parent p =pr.findById(Long.parseLong(id)).orElse(null);
		return p;
	}
	
	public List<Classe> getAllClasse()
	{	List<Classe> lclasse =new ArrayList<>();
	classeRepository.findAll().forEach(lclasse ::add);
		return lclasse;
	}
	
	public List<Jardin> getAllJardin()
	{	List<Jardin> ljar =new ArrayList<>();
	jardinRepository.findAll().forEach(ljar ::add);
		return ljar;
	}
	public List<Enfant> getAllEnfant()
	{	List<Enfant> lenfant =new ArrayList<>();
	enfantRepository.findAll().forEach(lenfant ::add);
		return lenfant;
	}
	
	public String affecterEnfant(String username,Long id,String nom,String a){
		Classe classe =getAllClasse().stream().filter(u->u.getNom().equals(nom)).findFirst().get();
		Jardin ljardin =getAllJardin().stream().filter(u->u.getParent().getNomP().equals(username)).findFirst().get();
		Enfant enfant =getAllEnfant().stream().filter(u->u.getId().equals(id)).findFirst().get();
		if(ljardin.equals(enfant.getJardin())){
			if(enfantRepository.findsizeofclasse(classe)<classe.getSize()&&enfant.getNiveau().equals(classe.getNiveau())){
				enfant.setClasse(classe);
				enfantRepository.save(enfant);
			}
			}
			if(!(enfantRepository.findsizeofclasse(classe)<classe.getSize())){
				a="Classe saturé";
			}
			else if(!(enfant.getNiveau().equals(classe.getNiveau()))){
				a="niveau de 'enfant est faux";
			}
			else if(!(ljardin.equals(enfant.getJardin()))){
				a="tu n'a pas le droit d'affecter cette enfant";
			}
				else
					a="affecter enfant succes";
			
			
		
	return a;	
	}
	
	public Niveau randomLetter() {
	    int pick = new Random().nextInt(Niveau.values().length);
	    return Niveau.values()[pick];
	}
	
	
}
