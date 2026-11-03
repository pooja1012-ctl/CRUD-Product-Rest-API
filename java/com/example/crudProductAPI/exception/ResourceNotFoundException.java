package com.example.crudProductAPI.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException(String message) {   //except error message
		super(message);
	}

}
