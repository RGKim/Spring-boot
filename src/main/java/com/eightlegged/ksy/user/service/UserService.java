package com.eightlegged.ksy.user.service;

import org.springframework.http.ResponseEntity;

import com.eightlegged.ksy.user.entity.User;

public interface UserService {
	
	public ResponseEntity<String> createUser(Long familyId, User user);
	public ResponseEntity<String> login(User user);

}
