package com.eightlegged.ksy.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eightlegged.ksy.user.entity.User;
import com.eightlegged.ksy.user.service.UserService;
import com.eightlegged.ksy.user.util.SiteUtils;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(
			value="/user/add",
			method=RequestMethod.POST,
			consumes={MediaType.APPLICATION_JSON_VALUE},
			produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> createUser(@RequestParam String idFamily, @RequestBody User user){
		return userService.createUser(SiteUtils.checkBlankOrNullToZero(idFamily), user);
	}
	
	@RequestMapping(
			value="/user/login",
			method=RequestMethod.POST,
			consumes={MediaType.APPLICATION_JSON_VALUE},
			produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> login(@RequestBody User user){
		return userService.login(user);
	}
}
