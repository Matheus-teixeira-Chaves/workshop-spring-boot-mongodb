package com.matheusfrazao.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusfrazao.workshopmongo.domain.User;
import com.matheusfrazao.workshopmongo.repository.UserRepository;
import com.matheusfrazao.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List <User> findAll () {
		return repo.findAll();
	}
	
	public User findById (String id) {
		User user = repo.findById(id).orElse(null);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}
}
