package com.proj.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class SessionController {

    @GetMapping("/apis/session")
    public ResponseEntity<?> checkSession(HttpSession session) {
        // 세션에서 사용자 정보 가져오기
        Object user = session.getAttribute("user");
        
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("세션이 없습니다. 로그인 필요.");
        }
        
        // 세션에 저장된 사용자 정보를 반환
        return ResponseEntity.ok(user);
    }
}

