package br.com.t4k.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.t4k.user.entity.User;
import br.com.t4k.user.repository.UserRepository;
import br.com.t4k.user.util.PasswordUtils;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ResponseEntity<String> createUser(Long familyId, User user) {
		User userCheck = userRepository.findUserByEmail(user);
		if(userCheck != null)
			return new ResponseEntity<String>("Email already in use." ,HttpStatus.BAD_REQUEST);
		
		userRepository.createUser(familyId, user);
		return new ResponseEntity<String>("User has been created.", HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<String> login(User user) {
		User userCheck = userRepository.findUserByEmail(user);
		if(userCheck == null)
			return new ResponseEntity<String>("Username not found.", HttpStatus.FORBIDDEN);
		
		if(PasswordUtils.isMatch(user.getPass(), userCheck.getPass()))
			return new ResponseEntity<String>("Welcome in T4K", HttpStatus.OK);
			
		return new ResponseEntity<String>("Username or password is invalid.", HttpStatus.BAD_REQUEST);
	}
	
}
