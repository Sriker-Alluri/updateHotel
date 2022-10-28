package com.project.hm.customExceptions;

public class BadRequestException extends RuntimeException {

	public BadRequestException(String message)
	{
		super(message);
	}

}
