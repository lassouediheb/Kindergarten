package tn.esprit.spring.services;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import tn.esprit.spring.entity.Bus;
import tn.esprit.spring.entity.Evenements;
import tn.esprit.spring.entity.Inscrits;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Participants;
import tn.esprit.spring.repository.BusRepository;
import tn.esprit.spring.repository.InscritsRepository;
import tn.esprit.spring.repository.ParentRepository;


@Service
public class InscritsServicelmpl implements InscritsService {
	
	@Autowired
	InscritsRepository inscritsRepository;
	@Autowired
	BusRepository busRepository;
	@Autowired
	ParentRepository parentRepository;
	
	private static final Logger L = LogManager.getLogger(InscritsServicelmpl.class);
	@Override
	public List<Inscrits> retrieveAllInscrits() {
		List<Inscrits> B=(List<Inscrits>) inscritsRepository.findAll();
		for (Inscrits Inscrits : B){
			L.info("Inscrits +++ :" + Inscrits);
		}
		return B;
		}
	
	/*	@Transactional	
	public void inscr(String matricule, String Idinscrip) {
		Inscrits InscritsEntity = inscritsRepository.findById(Long.parseLong(Idinscrip)).get();
		Bus BusEntity = busRepository.findById(Long.parseLong(matricule)).get();
		
		Integer nbrPlaces = busRepository.findById(Long.parseLong(matricule)).get().getNbrPlace();
		
		if (nbrPlaces-1==0){
			BusEntity.setEtat("saturée");
		}
		
		if (nbrPlaces>0){
			BusEntity.setNbrPlace(nbrPlaces-1);
			
			InscritsEntity.getBus().add(BusEntity);
			

		}
		
		
	}
	@Transactional	
	public void desinscr(String matricule, String Idinscrip) {
		Inscrits InscritsEntity = inscritsRepository.findById(Long.parseLong(Idinscrip)).get();
		Bus BusEntity = busRepository.findById(Long.parseLong(matricule)).get();
		
		Integer nbrPlaces = busRepository.findById(Long.parseLong(matricule)).get().getNbrPlace();
		
		if (nbrPlaces>0){
			BusEntity.setNbrPlace(nbrPlaces+1);
			
			InscritsEntity.getBus().remove(BusEntity);
			

		}	
		
	}*/
	
	
	
	@Override
    public Inscrits addInscrits(Inscrits B) {
		Inscrits insc =inscritsRepository.save(B);
		return insc;
     
}
	 @Override
     public void deleteInscrits(String B) {
     	
		 inscritsRepository.deleteById(Long.parseLong(B));
     } 
	
	
	 @Override
	 public Inscrits updateInscrits(Inscrits B) {
	 	return inscritsRepository.save(B);
	 		
	 }
	
		@Override
	 	public Inscrits retrieveInscrits(String idact) {
	 		
	 		return null;
	 	} 
	
	
		
		
		public int getinscrits(String nominscrit,long matricule){
			Inscrits inscrits = inscritsRepository.getParticipByMailEvent(nominscrit, matricule);
			if (inscrits==null){
				return 0;
			}
			else 
				return 1;
			
		}
		
		
		@Transactional
		public void InscrireBus(long id, long matricule) {
			Parent parentManagedEntity = parentRepository.findById(id).get();
			String nomI = parentManagedEntity.getUsername();
			String pnomI = parentManagedEntity.getPrenomP();
			String numI = parentManagedEntity.getNumP();
			Bus bus = busRepository.findById(matricule).get();
			Integer nbrPlace = busRepository.findById(matricule).get().getNbrPlace();
			if (getinscrits(nomI,matricule)==1){
				FacesMessage facesMessage =

						new FacesMessage("Error: vous etes deja inscrit !!");

						FacesContext.getCurrentInstance().addMessage("form1:btn",facesMessage);
						
						
			}
			
			else if (nbrPlace>0 && getinscrits(nomI,matricule)==0){
				Inscrits Insc = new Inscrits("non paye",nomI, pnomI,numI, bus);
				addInscrits(Insc);
				nbrPlace--;
				bus.setNbrPlace(nbrPlace);
				if (nbrPlace-1==0){
					bus.setEtat("Complet");
					
				}
				
			} 
			
			
		}
		
		
		
	
	
}
	
