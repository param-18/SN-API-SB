package com.illuminati.scnetapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.illuminati.scnetapi.entity.User;
import com.illuminati.scnetapi.repository.UserRepository;

@Service
public class UserService {
	
	//private List<User> users = new ArrayList<>();
	
	@Autowired
	UserRepository userrepo;
	
	public List<User> getAllUsers(){
		//return users;
		List<User> users = new ArrayList<>();
		userrepo.findAll().forEach(users::add);
		return users;
	   }
	
	public User getUser(String id) {
		//return users.stream().filter(user -> id.equals(user.getId())).findFirst().orElse(null);
		return userrepo.findById(id).get();
	}
	
	public void addUser(User user) {
		//users.add(user);
		userrepo.save(user);
	}

	public boolean updateUser(String id , User user) {
//		 User matchedUser = users.stream().filter(userO -> id.equals(userO.getId())).findFirst().orElse(null);
//	       	 
//		 if(matchedUser == null)
//			 return false;
//		 users.set(users.indexOf(matchedUser), user);
//		 return true;
		
		userrepo.save(user);
		return true;
	}
	
	public boolean deleteUser(String id) {
//		 User matchedUser = users.stream().filter(userO -> id.equals(userO.getId())).findFirst().orElse(null);
//	       	 
//		 if(matchedUser == null)
//			 return false;
//		 users.remove(matchedUser);
//		 return true;
		userrepo.deleteById(id);
		return true;
	}
	
	public List<User> getByFName(String fname) {
		return userrepo.getUsersByFName(fname);
	}
	
	public List<User> getByLName(String lname) {
		return userrepo.getUsersByLName(lname);
	}
}
