package com.illuminati.scnetapi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.illuminati.scnetapi.entity.*;
import com.illuminati.scnetapi.services.PostService;
@RestController
public class PostController {
	@Autowired
	PostService ps;
	@RequestMapping(value="/posts")
	public List<Post> getAllPosts(){
		return ps.getAllPosts();
	}
	@RequestMapping(value = "/posts/{id}")
	   public Post getPost(@PathVariable String id) {
		   return ps.getPost(id);
	}	
	@RequestMapping(method=RequestMethod.POST , value = "/addposts")
	   public void addPost(@RequestBody Post post) {
		   ps.addPost(post);
	   }
	@RequestMapping(method=RequestMethod.POST , value="/updateposts/{id}")
	public boolean updatePost(@RequestBody Post post , @PathVariable String id) {
		return ps.updatePost(id ,post);
	}	
	@RequestMapping(value="/deletepost/{id}")
	public ModelAndView deletePost(@PathVariable String id , Model model) {
	    ps.deletePost(id);
	    return modelAndView("dashboard.html");
	}	
	@RequestMapping(value="/postsbyuser/{id}")
	public ModelAndView getPostByUser(@PathVariable String id , Model model){
		model.addAttribute("posts",ps.getPostByUser(id));
		return modelAndView("postbyuser.html");		
	}	
	@RequestMapping(value="/postsbydate/{date}")
	public List<Post> getPostsByDate(@PathVariable String date){
		return ps.getPostsByDate(date);
	}
	public ModelAndView modelAndView(String mv) {
		   ModelAndView modv = new ModelAndView();
		   modv.setViewName(mv);
		   return modv;
	   }
}
