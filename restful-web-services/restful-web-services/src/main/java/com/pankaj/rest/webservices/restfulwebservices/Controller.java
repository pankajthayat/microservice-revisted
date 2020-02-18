package com.pankaj.rest.webservices.restfulwebservices;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/")
	public HelloWorldBean hello()
	{
		return new HelloWorldBean("hello! world");
	}
	
	@GetMapping(path="hello/{name}")
	public String pathVariableDemo(@PathVariable String name)
	{
		return "hello "+name;
	}
}
