package com.project.hm.customExceptions;

public class UserNotValidException extends RuntimeException{
	
	public UserNotValidException(String message)
	{
		super(message);
	}

}
