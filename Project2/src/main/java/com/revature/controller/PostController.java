package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.Post;
import com.revature.service.PostService;


//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PostController {
	@Autowired
	PostService bs;
	

	@GetMapping("/")
	public String list1() {
		System.out.println("index1");
		return "index1";
	}
	
		
	@GetMapping("/posts")
	//public String list(Model model) {
	
	public List<Post> list(){
		System.out.println("List of posts: ");
		List<Post> al = bs.listAllPosts();
//		System.out.println("List is ");
//		al.forEach(System.out::println);
		
		return al;
	}
	
	@RequestMapping(value="/posts/{id}", method=RequestMethod.GET)
	public Post findBook(@PathVariable int id)
	{System.out.println(id);
		Post b = bs.getPostbyId(id);
		return b;
	}
	
	@RequestMapping(value="/posts/{id}", method=RequestMethod.DELETE)
	public String deletePost(@PathVariable int id)
	{System.out.println(id);
		bs.deletePostById(id);
		return "Deleted";
	}
	
	@RequestMapping(value="/posts", method=RequestMethod.POST)
	public Post addBook(@RequestBody Post post)
	{System.out.println("Hello" + post);
		bs.createPost(post);
		return post;
	}
	
	@RequestMapping(value="/post", method=RequestMethod.PUT)
	public Post putBook(@RequestBody Post book)
	{System.out.println("Hello" + book);
		bs.createPost(book);
		return book;
	}
}
