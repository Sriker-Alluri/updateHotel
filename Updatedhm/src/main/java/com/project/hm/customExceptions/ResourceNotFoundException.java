package com.project.hm.customExceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException(String message, String string)
	{
		super(message);
	}

}
