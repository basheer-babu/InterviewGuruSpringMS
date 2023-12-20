package com.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.app.entity.User;

import reactor.core.publisher.Flux;


public interface UserRepository extends ReactiveMongoRepository<User, String> {
	
	/*
	 * Mono<User> findByUserName(String userName);
	 */
     public Flux<User> getByCompanyName(String name);

}
