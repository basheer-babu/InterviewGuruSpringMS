package com.app.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	
	@Id
	private String id;
	private String userName;
	private String companyName;
	private String questions;
	
	

}
