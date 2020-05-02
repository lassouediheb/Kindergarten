package tn.esprit.spring.services;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.VerificationToken;

public interface IUserService {
 
    User getUser(String verificationToken);
 
    void saveRegisteredUser(User user);
 
    void createVerificationToken(User user, String token);
 
    VerificationToken getVerificationToken(String VerificationToken);
}
