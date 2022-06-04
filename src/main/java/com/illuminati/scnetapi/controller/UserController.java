package com.illuminati.scnetapi.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.illuminati.scnetapi.entity.*;
import com.illuminati.scnetapi.services.UserService;
@RestController
public class UserController {
	@Autowired
	UserService us;
   @RequestMapping(value="/users")
   public ModelAndView getAllUsers(Model model){
	   model.addAttribute("users",us.getAllUsers());   
	   return modelAndView("users.html");
	   
   }   
   @RequestMapping(value = "/users/{id}")
   public User getUser(@PathVariable String id) {
	   return us.getUser(id);
   }   
   @RequestMapping(value = "/addusers")
   public ModelAndView addUser(Model model) {
	   model.addAttribute("user", new User());
	   return modelAndView("adduser.html");
   }   
   @PostMapping("/addeduser")
   public ModelAndView addedUser(@ModelAttribute("user") User user , Model model) {
	   us.addUser(user);
	   model.addAttribute("users",us.getAllUsers());
	   return modelAndView("users.html");
   }
   @RequestMapping(method=RequestMethod.POST , value="/updateusers/{id}")
	public boolean updateUser(@RequestBody User user , @PathVariable String id) {
		return us.updateUser(id ,user);
   }   
   @RequestMapping(value="/deleteuser/{id}")
   public ModelAndView deleteUser(@PathVariable String id , Model model) {
	   us.deleteUser(id);
	   model.addAttribute("users", us.getAllUsers());
	   return modelAndView("users.html");
   }
   @RequestMapping(value = "/userbyfname/{fname}")
   public List<User> getUserByFName(@PathVariable String fname) {
	   return us.getByFName(fname);
   }
   
   @RequestMapping(value = "/userbylname/{lname}")
   public List<User> getUserByLName(@PathVariable String lname) {
	   return us.getByLName(lname);
   }
   
   public ModelAndView modelAndView(String mv) {
	   ModelAndView modv = new ModelAndView();
	   modv.setViewName(mv);
	   return modv;
   }
}
