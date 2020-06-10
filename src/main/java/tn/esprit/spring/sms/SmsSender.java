package tn.esprit.spring.sms;

public interface SmsSender {

    void sendSms(SmsRequest smsRequest);
    void sendsmms(String tel);
 // void sendSms(String phoneNumber, String message);
}
