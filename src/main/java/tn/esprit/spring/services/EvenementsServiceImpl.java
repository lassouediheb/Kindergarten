package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entity.Evenements;
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.repository.EvenementsRepository;

@Service
public class EvenementsServiceImpl implements EvenementsService{
	@Autowired
	EvenementsRepository evenementsRepository;
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	   private JavaMailSender mailSender;
	   
	   public EvenementsServiceImpl(JavaMailSender javaMailSender) {
	 		this.javaMailSender = javaMailSender;
	 	}

	private static final Logger L = LogManager.getLogger(EvenementsServiceImpl.class);

	@Override
	public List<Evenements> retrieveAllEvenements() {
		List<Evenements> events = (List<Evenements>) evenementsRepository.findAll();

		for (Evenements event : events) {
			L.info("event +++ :" + event);
		}
		return events;
	}

	@Override
	public List<Evenements> getAllEvenements() {
		return (List<Evenements>) evenementsRepository.findAll();
	}

	@Override
	public Evenements retrieveEvenements(String id) {
		return evenementsRepository.findById(Long.parseLong(id)).orElse(null);
	}

	@Override
	public Evenements addEvenements(Evenements e,long id) {
		Evenements event = evenementsRepository.save(e);
		List<String> l =evenementsRepository.nbFidelite(id);
		for (int i = 0; i < l.size(); i++) {
			String recipientAddress = l.get(i);
			String subject = "Invitation à notre évènement";
			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo(recipientAddress);
			email.setSubject(subject);
			email.setText("\r\n" + "Bonjour, " + "Vous êtes invité à noutre prochain évènement  " + event.getNomE()
					+ " le " + event.getDateE() + " à " + event.getAdresseE() + "  soyez le bienvenue");
			javaMailSender.send(email);	
			}
		return event;
	}


	@Override
	public void deleteEvenements(String id) {
		evenementsRepository.deleteById(Long.parseLong(id));

	}

	@Override
	public Evenements updateEvenements(Evenements e) {
		Evenements event = evenementsRepository.save(e);
		return event;
	}

	@Override
	public Evenements getEvenementByIdEvent(long idEvent) {
		Evenements event = evenementsRepository.findById(idEvent).orElse(null);
		return event;

	}

	public List<Evenements> listAll(String keyword) {
		if (keyword != null) {
			return evenementsRepository.search(keyword);
		}
		return (List<Evenements>) evenementsRepository.findAll();
		
	}

	
	
	
	

}
