package com.proj.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proj.model.User;
import com.proj.service.UserService;

@RestController
@RequestMapping("/apis")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class MyPageController {

    private  UserService userService;

    public MyPageController(UserService userService) {
        this.userService = userService;
    }

    // 로그인된 사용자 정보 조회
    @GetMapping("/user-info")
    public ResponseEntity<User> getUserInfo(@RequestParam String username) {
        // 사용자 정보 조회
        User user = userService.findByUsername(username);
        
        if (user == null) {
            return ResponseEntity.status(404).body(null); // 사용자가 없을 경우 404 반환
        }
        
        return ResponseEntity.ok(user); // 사용자 정보 반환
    }
    

    }


