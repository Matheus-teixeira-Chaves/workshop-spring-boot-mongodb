package com.matheusfrazao.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusfrazao.workshopmongo.domain.Post;
import com.matheusfrazao.workshopmongo.repository.PostRepository;
import com.matheusfrazao.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById (String id) {
		Post user = repo.findById(id).orElse(null);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}
	
	public List <Post> findByTitle (String text) {
		return repo.searchTitle(text);
	}
}
