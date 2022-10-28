//package com.project.hm.service;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import com.project.hm.pay.OtpValidation;
//
//@Service
//public class OtpValidationService {
//	@Autowired
//	HttpSession session;
//
//	
//	public ResponseEntity reset(OtpValidation validation) {
//		if(session.getAttribute("otp").equals(validation.getOtp().toString())) {
//			String reg = String.valueOf(session.getAttribute("to"));
//		}
//		return null;
//	}
//}
