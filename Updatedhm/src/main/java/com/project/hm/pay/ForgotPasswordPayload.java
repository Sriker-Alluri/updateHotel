package com.project.hm.pay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForgotPasswordPayload {

	private String userName;
	private String oldPassword;
	private String newPassword;
}
