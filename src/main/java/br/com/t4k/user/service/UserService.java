package br.com.t4k.user.service;

import org.springframework.http.ResponseEntity;

import br.com.t4k.user.entity.User;

public interface UserService {
	
	public ResponseEntity<String> createUser(Long familyId, User user);
	public ResponseEntity<String> login(User user);

}
