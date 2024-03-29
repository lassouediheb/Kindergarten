package tn.esprit.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.VerificationToken;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.repository.VerificationTokenRepository;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
 
    @Autowired
    private VerificationTokenRepository tokenRepository;
     
    @Override
    public User getUser(String verificationToken) {
        User user = tokenRepository.findByToken(verificationToken).getUser();
        return user;
    }
     
    @Override
    public VerificationToken getVerificationToken(String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }
     
    @Override
    public void saveRegisteredUser(User user) {
        userRepository.save(user);
    }
     
    @Override
    public void createVerificationToken(User user, String token) {
        VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);
    }
    
    @Override
	public void deleteUser(String id) {
		userRepository.deleteById(Long.parseLong(id));
		
	}
	@Override
	public List<User> getAllUsers() {
	return (List<User>) userRepository.findAll();
	}
	
    
    public String userconnect(){
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String username="";
    	if (principal instanceof UserDetails) {
    	   username = ((UserDetails) principal).getUsername();
    	} else {
    	  username = principal.toString();
    	}
    	return username;
    	}
   
	
}