package com.app.service;

import com.app.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserService {

	public Mono<User> create(User user);

	public Flux<User> getAll();

	public Flux<User> getUser(String name);
	

}
