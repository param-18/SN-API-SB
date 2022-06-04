package com.illuminati.scnetapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.illuminati.scnetapi.entity.Post;
import com.illuminati.scnetapi.repository.PostRepository;

@Service
public class PostService {
     //private List<Post> posts = new ArrayList<>();
	@Autowired
	PostRepository postrepo;
	
	public List<Post> getAllPosts(){
		//return posts;
	  List<Post> posts = new ArrayList<>();
	  postrepo.findAll().forEach(posts::add);
	  return posts;
	}
	
	public Post getPost(String id) {
		//return posts.stream().filter(post -> id.equals(post.getId())).findFirst().orElse(null);
		return postrepo.findById(id).get();
	}
	
	public void addPost(Post post) {
		//posts.add(post);
		postrepo.save(post);
	}
	
	public boolean updatePost(String id , Post post) {
//		 Post matchedPost = posts.stream().filter(postO -> id.equals(postO.getId())).findFirst().orElse(null);
//	       	 
//		 if(matchedPost == null)
//			 return false;
//		 posts.set(posts.indexOf(matchedPost), post);
//		 return true;
		postrepo.save(post);
		return true;
	}
	
	public boolean deletePost(String id) {
//		 Post matchedPost = posts.stream().filter(postO -> id.equals(postO.getId())).findFirst().orElse(null);
//	       	 
//		 if(matchedPost == null)
//			 return false;
//		 posts.remove(matchedPost);
//		 return true;
		postrepo.deleteById(id);
		return true;
	}
	
	public List<Post> getPostByUser(String userId){
		List<Post> allPosts = getAllPosts();
		return allPosts.stream().filter(post -> post.getUser().getId().equals(userId)).toList();
	}
	
	public List<Post> getPostsByDate(String date){
		return postrepo.getByDate(date);
	}
}
