package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.controllers.ReclamationController;
import tn.esprit.spring.entity.Reclamation;


@SpringBootTest
class SpringPdevKindergartenApplicationTests {
	@Autowired
	ReclamationController reclamationcontroller;

	@Test
	void contextLoads() {
		System.out.println("aa"+reclamationcontroller.traiter(new Reclamation(1,  "ec",  "ContenuRec",null , null, 0)));
		 
	}

}
