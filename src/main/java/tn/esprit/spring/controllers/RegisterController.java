package tn.esprit.spring.controllers;





import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.ERole;
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.entity.OnRegistrationCompleteEvent;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.JardinRepository;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.UserService;


@Controller(value = "registreController")
@Join(path = "/signup", to = "/signup.jsf")
@Component
public class RegisterController {
	
	
	
		@Autowired
		UserRepository userRepository;
		@Autowired
		RoleRepository roleRepository;
		@Autowired
		JardinRepository jardinRepository;
		

		@Autowired
		PasswordEncoder encoder;
		@Autowired
		ApplicationEventPublisher eventPublisher;
		
		private String username;
		private String password;
		private String email;
		

		


		public String doSignupjardin() {
			String navigateTo = "null";
			if (userRepository.existsByUsername(username)) {
				FacesMessage facesMessage =

						new FacesMessage("Error: Username is already taken!");

						FacesContext.getCurrentInstance().addMessage("form1:btn",facesMessage);
			}

			else if (userRepository.existsByEmail(email)) {
				FacesMessage facesMessage =

						new FacesMessage("Error: Email is already in use!");

						FacesContext.getCurrentInstance().addMessage("form1:btn",facesMessage);
			}
			else
			{
				Jardin jardin = new Jardin(username, 
						 email,
						 encoder.encode(password));
				Set<Role> roles = new HashSet<>();
				Role userRole = roleRepository.findByName(ERole.ROLE_JARDINDENFANT)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(userRole);
				jardin.setRoles(roles);
				userRepository.save(jardin);
				String appUrl = "";
				Jardin registered= jardin;
				eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, appUrl));
				navigateTo="login1.xhtml?faces-redirect=true";
				FacesMessage facesMessage =

						new FacesMessage("Registered successfully, please verify your account!");

						FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
			}
			
			return navigateTo;
			
		}


		public String doSignupparent() {
			String navigateTo = "null";
			if (userRepository.existsByUsername(username)) {
				FacesMessage facesMessage =

						new FacesMessage("Error: Username is already taken!");

						FacesContext.getCurrentInstance().addMessage("form1:btn",facesMessage);
			}

			else if (userRepository.existsByEmail(email)) {
				FacesMessage facesMessage =

						new FacesMessage("Error: Email is already in use!");

						FacesContext.getCurrentInstance().addMessage("form1:btn",facesMessage);
			}
			else
			{
				Parent parent = new Parent(username, 
						 email,
						 encoder.encode(password));
				Set<Role> roles = new HashSet<>();
				Role userRole = roleRepository.findByName(ERole.ROLE_PARENT)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(userRole);
				parent.setRoles(roles);
				userRepository.save(parent);
				String appUrl = "";
				User registered= parent;
				eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, appUrl));
				navigateTo="login1.xhtml?faces-redirect=true";
				FacesMessage facesMessage =

						new FacesMessage("Registered successfully, please verify your account!");

						FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
			}
			return navigateTo;
			
		}




		public UserRepository getUserRepository() {
			return userRepository;
		}





		public void setUserRepository(UserRepository userRepository) {
			this.userRepository = userRepository;
		}





		public RoleRepository getRoleRepository() {
			return roleRepository;
		}





		public void setRoleRepository(RoleRepository roleRepository) {
			this.roleRepository = roleRepository;
		}





		public PasswordEncoder getEncoder() {
			return encoder;
		}





		public void setEncoder(PasswordEncoder encoder) {
			this.encoder = encoder;
		}





		public ApplicationEventPublisher getEventPublisher() {
			return eventPublisher;
		}





		public void setEventPublisher(ApplicationEventPublisher eventPublisher) {
			this.eventPublisher = eventPublisher;
		}





		public String getUsername() {
			return username;
		}





		public void setUsername(String username) {
			this.username = username;
		}





		public String getPassword() {
			return password;
		}





		public void setPassword(String password) {
			this.password = password;
		}





		public String getEmail() {
			return email;
		}





		public void setEmail(String email) {
			this.email = email;
		}
	

}
	
