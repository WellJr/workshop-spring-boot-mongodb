package com.wellingtonjunior.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wellingtonjunior.workshopmongo.domain.Post;
import com.wellingtonjunior.workshopmongo.resources.util.URL;
import com.wellingtonjunior.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService postService;
	
	
	@RequestMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = postService.findById(id);
		
		return  ResponseEntity.ok().body(obj);			
	}
	
	@RequestMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text){
		List<Post> posts = postService.findByTitle(URL.decodeParam(text));
		
		return  ResponseEntity.ok().body(posts);	
		
	}
	
	
}
