package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.controllers.ReclamationController;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.services.ReclamationService;


@SpringBootTest
class SpringPdevKindergartenApplicationTests {
	@Autowired
	ReclamationController reclamationcontroller;
	

	@Test
	void contextLoads() {
//		System.out.println("aa"+reclamationService.tel(2));
	
	
	}

}
