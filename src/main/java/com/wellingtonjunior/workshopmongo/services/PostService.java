package com.wellingtonjunior.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellingtonjunior.workshopmongo.domain.Post;
import com.wellingtonjunior.workshopmongo.repository.PostRepository;
import com.wellingtonjunior.workshopmongo.services.exepetions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não econtrado"));
	}
	
	public List<Post> findByTitle(String text) {
//		return postRepository.findByTitleContainingIgnoreCase(text);
		return postRepository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		
		return postRepository.fullSearch(text, minDate, maxDate);
	}
}
