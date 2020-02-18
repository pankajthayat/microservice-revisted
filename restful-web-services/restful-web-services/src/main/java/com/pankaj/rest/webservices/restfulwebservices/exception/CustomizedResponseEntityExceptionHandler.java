package com.pankaj.rest.webservices.restfulwebservices.exception;



import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;





// ResponseEntityExceptionHandler this to provide centerlise exception handler... default exception for all our request...we have to extends
// default exception provided by spring.. to provide our own we have to override it.

//@ControllerAdvice // so that it will be applicable across all the controller.. go to docs...we can use it in others also.
//@RestController //bcoz this is provide response back when exception occur 
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler 
	extends ResponseEntityExceptionHandler {

		@ExceptionHandler({Exception.class}) // this will handle all the exception
		public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {// we are copying the method signature of handleException from RsponseE.. class
			ExceptionResponse res=new ExceptionResponse(
					new Date(), 
					ex.getMessage(), 
					request.getDescription(false)); // choose the description carefully
			System.out.println("=====i am in exception======");
		return new ResponseEntity(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}
//		@ExceptionHandler(Exception.class)
//		public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
//			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
//					request.getDescription(false));
//			return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
}


//@RestControllerAdvice would be a good option 
//
//@RestControllerAdvice = @RestController + @ControllerAdvice

//ControllerAdvice is used for features you would want to implement across multiple controllers.
//
//https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/ControllerAdvice.html