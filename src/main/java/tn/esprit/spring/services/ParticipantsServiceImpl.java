package tn.esprit.spring.services;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.entity.Evenements;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Participants;
import tn.esprit.spring.repository.EvenementsRepository;
import tn.esprit.spring.repository.ParentRepository;
import tn.esprit.spring.repository.ParticipantsRepository;

@Service
public class ParticipantsServiceImpl implements ParticipantsService {
	
	@Autowired
	ParticipantsRepository participantsRepository;
	
	@Autowired
	EvenementsRepository evenementsRepository;
	
	@Autowired
	ParentRepository parentRepository;
	
	
	
	private static final Logger L = LogManager.getLogger(ParticipantsServiceImpl.class);
	
	@Transactional
	public void ParticiperEvent(long id, long idEvent) {
		Parent parentManagedEntity = parentRepository.findById(id).get();
		String nomP = parentManagedEntity.getNomP();
		String pnomP = parentManagedEntity.getPrenomP();
		String numP = parentManagedEntity.getNumP();
		String mailP = parentManagedEntity.getEmail();
		Evenements evenementsManagedEntity = evenementsRepository.findById(idEvent).get();
		Integer nbPlaces = evenementsRepository.findById(idEvent).get().getNbPlace();
		if (getParticip(mailP,idEvent)==1){
			FacesMessage facesMessage =

					new FacesMessage("Error: vous avez participé!");

					FacesContext.getCurrentInstance().addMessage("form1:btn",facesMessage);
		}
		
		else if (nbPlaces>0 && getParticip(mailP,idEvent)==0){
			Participants p = new Participants(nomP, pnomP, numP, mailP, evenementsManagedEntity);
			addParticipants(p);
			nbPlaces--;
			evenementsManagedEntity.setNbPlace(nbPlaces);
			if (nbPlaces-1==0){
				evenementsManagedEntity.setStatutE("Complet");
				
			}
			
		} 
		
		
	}
	
	public int getParticip(String mailParticip,long idEvent){
		Participants part = participantsRepository.getParticipByMailEvent(mailParticip,idEvent);
		if (part==null){
			return 0;
		}
		else 
			return 1;
		
	}
	
	
	

	@Override
	public List<Participants> retrieveAllParticipants() {
		List<Participants> participants = (List<Participants>) participantsRepository.findAll();
		
		for (Participants p : participants){
			L.info("p +++ :" + p);
		}
		return participants;
	}
	
	@Override
	public Participants addParticipants(Participants p) {
		Participants particip =participantsRepository.save(p);
		return particip;
		
	}

	@Override
	public void deleteParticipants(String id) {
		participantsRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Participants updateParticipants(Participants p) {
		Participants particip =participantsRepository.save(p);
		return particip;
	}

	@Override
	public Participants retrieveParticipants(String id) {
		Participants particip =participantsRepository.findById(Long.parseLong(id)).orElse(null);
		return particip;
	}
	
	public List<Participants> getAllParticipantsByIdEvent(long idEvent){
		return participantsRepository.getAllParticipantsByIdEvent(idEvent);
	}
	
	public int getNombreParticipantsByidEvent(long idEvent ){
		return participantsRepository.nbParticip(idEvent);
	}

	
	
	
	
	
	
}
