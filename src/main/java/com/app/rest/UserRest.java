package com.app.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.User;
import com.app.service.IUserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/user")
public class UserRest {

	private static final Logger logger = LoggerFactory.getLogger(UserRest.class);

	@Autowired
	private IUserService service;

	@PostMapping("/save")
	public Mono<ResponseEntity<User>> save(@RequestBody User user) {
		logger.info("Creating User");
		return service.create(user).map(saved -> new ResponseEntity<>(saved, HttpStatus.CREATED));
	}

	@GetMapping("/fetchAll")
	public ResponseEntity<Flux<User>> fetchAll() {
		logger.info("getting All Users");
		Flux<User> user = service.getAll();
		return new ResponseEntity<Flux<User>>(user, HttpStatus.OK);
	}

	@GetMapping("/company/{companyName}")
	public ResponseEntity<Flux<User>> getBy(@PathVariable String companyName) {

		Flux<User> find = service.getUser(companyName);
		try {
			logger.info("getting by Company Name :" + companyName);
			return new ResponseEntity<Flux<User>>(find, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Failed in get by Company Name");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}

	}

}
