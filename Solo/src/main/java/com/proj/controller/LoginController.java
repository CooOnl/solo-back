package com.proj.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proj.service.UserService;

@RestController
@RequestMapping("/apis")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	
	 private UserService userService;
	
	public LoginController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/signin")
	public ResponseEntity<String> login(@RequestParam(name = "username") String username,@RequestParam(name = "userpassword") String userpassword){
		try{
			// 인증 및 토큰 생성
			String token = userService.authenticate(username,userpassword);
			return ResponseEntity.ok(token);
		}catch(RuntimeException e) {
			return ResponseEntity.status(401).body("Authentication failed : " + e.getMessage());
		}
	}

}
