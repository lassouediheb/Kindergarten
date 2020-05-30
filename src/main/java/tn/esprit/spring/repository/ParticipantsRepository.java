package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Participants;

public interface ParticipantsRepository extends CrudRepository<Participants, Long> {

}
