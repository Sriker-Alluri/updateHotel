package com.project.hm.pay;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class TwilliopasscodeValidation {

	
	private String otp;
	private String password;
}
