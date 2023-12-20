package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.repository.UserRepository;
import com.app.service.IUserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository repo;

	public Mono<User> create(User user) {
		return repo.save(user);
	}

	public Flux<User> getAll() {
		return repo.findAll().switchIfEmpty(Flux.empty());

	}

	public Flux<User> getUser(String name) {
		return repo.getByCompanyName(name);

	}

	/*
	 * public Flux<User> getUser(String name) { return repo.getByCompanyName(name);
	 * 
	 * }
	 */

}
