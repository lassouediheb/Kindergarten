package tn.esprit.spring.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements ReclamationService {
	@Autowired
	ReclamationRepository reclamtationRepository;
	private static final Logger L = LogManager.getLogger(ReclamationServiceImpl.class);
	LocalDate date = LocalDate.now();

	@Override
	public Reclamation ajouterReclamation(Reclamation reclamation) {
		

		reclamation.setDateRec(convertToDateViaSqlDate(date));
		return reclamtationRepository.save(reclamation);

	}

	@Override
	public List<Reclamation> retrieveAllReclamation() {
		List<Reclamation> reclamations = (List<Reclamation>) reclamtationRepository.findAll();
		for (Reclamation reclamation : reclamations) {
			L.info("reclamation +++ : " + reclamation);
		}
		return reclamations;
	}

	@Override
	public Reclamation updateReclamation(Reclamation R) {
		return reclamtationRepository.save(R);

	}

	@Override
	public void deleteReclamation(String id) {
		reclamtationRepository.deleteById((int) Long.parseLong(id));

	}

	@Override
	public int getNombreReclamationJPQL() {
		return reclamtationRepository.countreclamation();
	}

	@Override
	public List<Reclamation> SearchBySujet(String kelma) {

		return reclamtationRepository.findBySujetRecLike("%" + kelma + "%");

	}

	@Override
	public List<Reclamation> SujetOrderDesc(String kelma) {
		return reclamtationRepository.findBySujetRecLikeOrderByDateRecDesc("%" + kelma + "%");

	}

	@Override
	public Reclamation traiterReclamation(Reclamation R) {
		R.setEtat(1);

		R.setDateT(convertToDateViaSqlDate(date));

		return reclamtationRepository.save(R);

	}

	public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
		return java.sql.Date.valueOf(dateToConvert);
	}

	@Override
	public List<Number> dateDeTraitement() {
		return reclamtationRepository.dateDiff();

	}

	public int matchStrings(String firstString, String SecondString) {

		int matchingCount = 0;

		// Getting the whole set of words in to array.
		String[] allWords = firstString.split("\\s");
		Set<String> firstInputset = new HashSet<String>();

		// getting unique words in to set
		for (String string : allWords) {
			firstInputset.add(string);
		}

		// Loop through the set and check whether number of words occurrence in second
		// String
		for (String string : firstInputset) {
			if (SecondString.toLowerCase().contains(string.toLowerCase())) {
				matchingCount++;
			}
		}
		return matchingCount;
	}

	@Override
	public List<Reclamation> getAllReclamations() {
		return (List<Reclamation>) reclamtationRepository.findAll();
	}

	@Override
	public List<Reclamation> getUReclamations(User u) {
		
		return (List<Reclamation>) reclamtationRepository.findByUser(u);
	}

	
	@Override
	public int getNombreRmonth(int m) {
		return reclamtationRepository.countmonth(m);
		}
	
	@Override
	public int getNombreTmonth(int m) {
		return reclamtationRepository.Tmonth(m);
		}
	@Override
	public String tel(long i) {
		if (reclamtationRepository.type(i).compareTo("parent")==0)
		{return reclamtationRepository.nump(i);
			
		}
		return reclamtationRepository.numj(i);
//		return reclamtationRepository.type(i);
	}
	
}
