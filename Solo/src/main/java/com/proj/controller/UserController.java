package com.proj.controller;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proj.model.User;
import com.proj.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/apis")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class UserController {
private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//회원가입 API
	@PostMapping("/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public User signUp(@RequestBody @Valid User user) {
		System.out.println("유저 번호" + user.getUsernumber());
		return userService.signUp(user);
	}
}
