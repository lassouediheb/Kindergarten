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
import tn.esprit.spring.entity.OnRegistrationCompleteEvent;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;


@Controller(value = "registreController")
@Join(path = "/signup", to = "/signup.jsf")
@Component
public class RegisterController {
	
	
	
		@Autowired
		UserRepository userRepository;
		@Autowired
		RoleRepository roleRepository;

		@Autowired
		PasswordEncoder encoder;
		@Autowired
		ApplicationEventPublisher eventPublisher;
		
		private String username;
		private String password;
		private String email;
		private String adresseuser;
		private Date datedenaissance;
		private long numtel ;

		


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
				User user = new User(username, 
						 email,
						 encoder.encode(password),adresseuser,datedenaissance,numtel);
				Set<Role> roles = new HashSet<>();
				Role userRole = roleRepository.findByName(ERole.ROLE_JARDINDENFANT)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(userRole);
				user.setRoles(roles);
				userRepository.save(user);
				String appUrl = "";
				User registered= user;
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
				User user = new User(username, 
						 email,
						 encoder.encode(password),adresseuser,datedenaissance,numtel);
				Set<Role> roles = new HashSet<>();
				Role userRole = roleRepository.findByName(ERole.ROLE_PARENT)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(userRole);
				user.setRoles(roles);
				userRepository.save(user);
				String appUrl = "";
				User registered= user;
				eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, appUrl));
				navigateTo="login1.xhtml?faces-redirect=true";
				FacesMessage facesMessage =

						new FacesMessage("Registered successfully, please verify your account!");

						FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
			}
			return navigateTo;
			
		}



		public String getAdresseuser() {
			return adresseuser;
		}


		public void setAdresseuser(String adresseuser) {
			this.adresseuser = adresseuser;
		}


		public Date getDatedenaissance() {
			return datedenaissance;
		}


		public void setDatedenaissance(Date datedenaissance) {
			this.datedenaissance = datedenaissance;
		}


		public long getNumtel() {
			return numtel;
		}


		public void setNumtel(long numtel) {
			this.numtel = numtel;
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
	
