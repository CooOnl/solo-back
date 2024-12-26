package com.proj.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proj.jwt.JwtUtil;

@RestController
@RequestMapping("/apis")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class SigninController {
	
	 private  AuthenticationManager authenticationManager;
	    private  JwtUtil jwtUtil;

	    public SigninController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
	        this.authenticationManager = authenticationManager;
	        this.jwtUtil = jwtUtil;
	    }

	    @PostMapping("/signin")
	    public String login(@RequestParam(name= "username") String username, @RequestParam(name= "userpassword") String userpassword) {
	        // 사용자 인증
	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(username, userpassword)
	        );

	        // JWT 토큰 생성 후 반환
	        return jwtUtil.generateToken(authentication.getName());
	    }
}
