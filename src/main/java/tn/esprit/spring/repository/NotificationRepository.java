package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Notification;



@Repository
public interface NotificationRepository extends CrudRepository<Notification,Integer> {

}
