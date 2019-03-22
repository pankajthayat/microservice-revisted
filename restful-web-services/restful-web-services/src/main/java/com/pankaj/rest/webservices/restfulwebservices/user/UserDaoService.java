package com.pankaj.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class UserDaoService {
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
				users.add(user);
				//return user;
				URI location=ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(user.getId()).toUri();
				return ResponseEntity.created(location).build();
			}
			
			public User findOne(int id) {
				for(User u:users) {
					if(u.getId()==id)
						return u;
				}
				return null;
			}
}
