package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Evenements;
import tn.esprit.spring.services.EvenementsService;


@RestController
@RequestMapping("/SpringMVC/servlet")
public class EvenementsRestController {
	
	@Autowired
	EvenementsService evenementsService;
	
	//http://localhost:8083/SpringMVC/servlet/retrieve-evenements/{evenement-idEvent}
	 @GetMapping("/retrieve-evenements/{evenement-idEvent}")
	 @ResponseBody
	 public Evenements retrieveEvenements(@PathVariable("evenement-idEvent") String id) {
	 return evenementsService.retrieveEvenements(id);
	 }

}
