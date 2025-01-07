package com.proj.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.DTO.UserDto;
import com.proj.model.User;
import com.proj.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/apis")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class SigninController {

    private final UserService userService;

    public SigninController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody User user, HttpServletRequest request) {
        try {
            User authenticatedUser = userService.authenticate(user.getUsername(), user.getUserpassword());

            if (authenticatedUser != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", authenticatedUser.getUsername());
//                session.setAttribute("user", );
                session.setMaxInactiveInterval(2 * 60);
                
                UserDto userDto = new UserDto(
                		authenticatedUser.getUsername(),
                		authenticatedUser.getName(),
                		authenticatedUser.getEmail(),
                		authenticatedUser.getUserbirth(),
                		authenticatedUser.getUsernumber(),
                		authenticatedUser.getRole()
                		);
                		
                
                // 필요한 데이터를 모두 반환
                Map<String, Object> response = new HashMap<>();
//                response.put("message", "로그인 성공");
//                response.put("username", authenticatedUser.getUsername());
//                response.put("name", authenticatedUser.getName());
//                response.put("useremail", authenticatedUser.getEmail());
//                response.put("userbirth", authenticatedUser.getUserbirth());
//                response.put("usernumber", authenticatedUser.getUsernumber());
                response.put("user",userDto);
                
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디 또는 비밀번호가 잘못되었습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류가 발생했습니다");
        }
    }

    
    

//    @GetMapping("/check-login")
//    public ResponseEntity<?> checkLoginStatus(HttpServletRequest request) {
//        String username = (String) request.getSession().getAttribute("username");
//
//        if (username != null) {
//            Map<String, Object> response = new HashMap<>();
//            response.put("status", "logged_in");
//            response.put("username", username);
//            return ResponseEntity.ok(response); // 로그인 상태 반환
//        } else {
//            Map<String, String> response = new HashMap<>();
//            response.put("status", "not_logged_in");
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response); // 로그인되지 않음
//        }
//    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // 기존 세션 확인
        if (session != null) {
            session.invalidate(); // 세션 무효화
        }
        return ResponseEntity.ok("로그아웃 성공");
    }
}
