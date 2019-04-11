package com.pankaj.rest.webservices.restfulwebservices.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pankaj.rest.webservices.restfulwebservices.exception.UserNotFoundException;

@RestController
public class UserResource {

	@Autowired
	UserDaoService service;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers()
	{
		//return service.findAll();
		return userRepository.findAll();
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity getUser(@PathVariable int id)
	{
		User user= userRepository.findById(id).get();  //service.findOne(id);
		if(user==null)
			throw new  UserNotFoundException("id - "+id);
		return new ResponseEntity(user,HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity createUser(@RequestBody User user)
	{
		 return service.save(user);
	}
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable int id)
	{
		service.deleteById(id);
//		if(user==null)
//			throw new  UserNotFoundException("id - "+id);
		
	}
	
	@PutMapping("/update")
	public User updateUser(User user)
	{
		return userRepository.save(user);
	}
}
