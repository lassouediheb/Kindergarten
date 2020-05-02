package tn.esprit.spring.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.OnRegistrationCompleteEvent;
import tn.esprit.spring.entity.User;

@Component
public class RegistrationListener implements
  ApplicationListener<OnRegistrationCompleteEvent> {
  
    @Autowired
    private IUserService service;
    
    private JavaMailSender javaMailSender;
  
   @Autowired
   private JavaMailSender mailSender;
   
   public RegistrationListener(JavaMailSender javaMailSender) {
 		this.javaMailSender = javaMailSender;
 	}
 
    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }
 
    private void confirmRegistration(OnRegistrationCompleteEvent event) {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        service.createVerificationToken(user, token);
         
        String recipientAddress = user.getEmail();
        String subject = "Registration Confirmation";
        String confirmationUrl = event.getAppUrl() + "/regitrationConfirm/token/" + token;
        //String message = messages.getMessage("message.regSucc", null, event.getLocale());
         
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText( "\r\n" + "http://localhost:8083/api/auth" + confirmationUrl);
        javaMailSender.send(email);
    }
}