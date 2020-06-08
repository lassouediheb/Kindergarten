package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Participants;

public interface ParticipantsService {
	List<Participants> retrieveAllParticipants();
	Participants addParticipants(Participants p); 
	void deleteParticipants(String id);
	Participants updateParticipants(Participants p);
	Participants retrieveParticipants(String id);
	
	public List<Participants> getAllParticipantsByIdEvent(long idEvent);
	public int getNombreParticipantsByidEvent(long idEvent );
	
	public void ParticiperEvent(long id, long idEvent);


}
