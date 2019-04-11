package com.pankaj.rest.webservices.restfulwebservices.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(){
		
	}
	 public UserNotFoundException(String msg){
		super(msg);
		
	}
}
