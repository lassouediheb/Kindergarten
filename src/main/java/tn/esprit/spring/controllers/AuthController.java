package tn.esprit.spring.controllers;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import tn.esprit.spring.entity.ERole;
import tn.esprit.spring.entity.OnRegistrationCompleteEvent;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.VerificationToken;
import tn.esprit.spring.payload.request.LoginRequest;
import tn.esprit.spring.payload.request.SignupRequest;
import tn.esprit.spring.payload.response.JwtResponse;
import tn.esprit.spring.payload.response.MessageResponse;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.security.jwt.JwtUtils;
import tn.esprit.spring.services.IUserService;
import tn.esprit.spring.services.UserDetailsImpl;
import tn.esprit.spring.services.UserDetailsServiceImpl;
import tn.esprit.spring.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private IUserService service;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	ApplicationEventPublisher eventPublisher;
	
	

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		
		

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		User U = userRepository.findByUsername(userDetails.getUsername())
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDetails.getUsername()));
		
		if (!U.isEnabled()) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Please Confirm your Account, We've sent you a confirmation email"));
		}
		else
		
		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest,HttpServletRequest request) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role jardin = roleRepository.findByName(ERole.ROLE_JARDINDENFANT)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(jardin);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "parent":
					Role modRole = roleRepository.findByName(ERole.ROLE_PARENT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_JARDINDENFANT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		
		
		userRepository.save(user);
		String appUrl = request.getContextPath();
		User registered= user;
		eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), appUrl));
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<?> UpdateUser(@PathVariable(value = "id") Long idUser,@Valid @RequestBody SignupRequest signUpRequest) {	
		if (!userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username not found!"));
		}

		// update user's account
		User U = userDetailsServiceImpl.findOne(idUser);
		//U.setUsername(signUpRequest.getUsername());
		U.setEmail(signUpRequest.getEmail());
		U.setPassword(encoder.encode(signUpRequest.getPassword()));
	
		
		userDetailsServiceImpl.updateUser(U);

		return ResponseEntity.ok(new MessageResponse("User updated successfully!"));
	}

	@PutMapping("/disableUser/{username}")
public ResponseEntity<?> DisableUser(@PathVariable(value = "username") String username,@Valid @RequestBody SignupRequest signUpRequest) {
		
		if (!userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username not found!"));
		}
		
		User U = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		U.setEtatAcc(false);
		
		userDetailsServiceImpl.updateUser(U);
		
		return ResponseEntity.ok(new MessageResponse("User Disabled successfully!"));
	}
	
	
	@GetMapping("/regitrationConfirm/token/{token}")
	public ResponseEntity<?> confirmRegistration
	  (WebRequest request, Model model, @PathVariable(value = "token") String token) {
	  
	    Locale locale = request.getLocale();
	     
	    VerificationToken verificationToken = userService.getVerificationToken(token);
	    if (verificationToken == null) {
			return ResponseEntity.ok(new MessageResponse("InvaLID vERFICATION Token"));

	    }
	     
	    User user = verificationToken.getUser();
	    Calendar cal = Calendar.getInstance();
	    if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
			return ResponseEntity.ok(new MessageResponse("Link Expired!"));

	    } 
	     
	    user.setEnabled(true); 
	    userDetailsServiceImpl.updateUser(user);
		return ResponseEntity.ok(new MessageResponse("Account Confirmed with succes"));
	}
		
}
