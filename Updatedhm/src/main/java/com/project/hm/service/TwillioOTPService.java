//package com.project.hm.service;
//
//import java.text.ParseException;
//import java.util.Random;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.project.hm.entity.RegistrationVerfication;
//import com.project.hm.entity.UserRegistration;
//import com.project.hm.pay.TwillioPasscode;
//import com.project.hm.pay.TwilliopasscodeValidation;
//import com.project.hm.repository.UserRepository;
//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.rest.api.v2010.account.MessageCreator;
//import com.twilio.rest.proxy.v1.service.Session;
//import com.twilio.type.PhoneNumber;
//
//@Service
//public class TwillioOTPService {
//	
//
//	@Autowired
//	HttpSession session;
//	
//	@Autowired
//	BCryptPasswordEncoder encoder;
//	
//	@Autowired
//	UserRepository repo;
//	
//	
//	int i;
//	String phoneNumber;
//	
//	private final String ACCOUNT_SID = "";
//	private final String token = "";
//	private final String trialNumber = "";
//	
//	
//	public ResponseEntity send(TwillioPasscode passcode) throws ParseException{
//		sendOtp(passcode.getPhoneNumber());
//		return new ResponseEntity(HttpStatus.OK);
//	}
//	public ResponseEntity sendRegisterOtp(RegistrationVerfication veriication) throws ParseException {
//	sendOtp(veriication.getPhoneNumber());
//	return new ResponseEntity(HttpStatus.OK);
//	}
//	
//	public void sendOtp(String phoneNumber) {
//		this.phoneNumber = phoneNumber;
//		
//		if(phoneNumber != null)
//			Twilio.init(ACCOUNT_SID,token);
//		
//		Random r = new Random();
//		this.i= r.nextInt(9999);
//		
//		if(this.i<1000) {
//			this.i +=1000;
//		}
//		
//		String message = "your OTP is "+ i;
//		
//		MessageCreator creator = Message.creator(new PhoneNumber(phoneNumber), new PhoneNumber(trialNumber), message);
//				System.out.println(phoneNumber);
//		System.out.println(i);
//		session.setAttribute("phone", phoneNumber);
//		session.setAttribute("otp", String.valueOf(i));
//		session.setMaxInactiveInterval(5*60);
//	}
//	
//	public ResponseEntity validate(TwilliopasscodeValidation passcode) throws ParseException {
//
//		if (session.getAttribute("otp2").equals(passcode.getOtp())) {
//			UserRegistration reg = repo.findByPhoneNumber(session.getAttribute("phone").toString());
//			reg.setPassword(encoder.encode(passcode.getPassword().toString()));
//			repo.save(reg);
//			session.invalidate();
//			return new ResponseEntity("password is changed", HttpStatus.OK);
//		} else {
//			return new ResponseEntity("wrong otp", HttpStatus.BAD_REQUEST);
//		}
//	}
//
//}
