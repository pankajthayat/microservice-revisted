package com.pankaj.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class UserDaoService {
	
	@Autowired
	UserRepository repository;
	
	private static int usersCount;
	public static List<User> users=new ArrayList();
			static {
		users.add(new User(1,"pankaj", new Date()));
		users.add(new User(2,"rahul", new Date()));
		users.add(new User(3,"manish", new Date()));
	}
			
			
			public List<User> findAll(){
				return users;
			}
			
			
         public ResponseEntity save(User user) {
				if(user.getId()==null) {
					user.setId((++usersCount));
				}
				//users.add(user);
				//return user;
				repository.save(user);
				URI location=ServletUriComponentsBuilder.fromCurrentRequest() //return current uri
						.path("/{id}") // PATH method allows sth to append to uri
						.buildAndExpand(user.getId()).toUri(); //replace id
				return ResponseEntity.created(location).build();
			
			}
			
			public User findOne(int id) {
				for(User u:users) {
					if(u.getId()==id)
						return u;
				}
				return null;
			}
			public void deleteById(int id) {
//				Iterator<User> itr =users.iterator();
//				while(itr.hasNext())
//				{
//					User user = itr.next();
//					if(user.getId()==id) {
//						itr.remove();
//						return user;
//					}
//				}
				
			 repository.deleteById(id);;
			}
}
