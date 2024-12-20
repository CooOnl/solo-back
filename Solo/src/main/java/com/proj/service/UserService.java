package com.proj.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proj.model.User;
import com.proj.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }
    
    
    public String authenticate(String username, String password) {
        try {
            // Spring Security를 사용하여 인증 처리
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );
            return authentication.getName(); // 인증된 사용자 이름 반환
//            return jwtTokenProvider.generateToken(authentication);
        } catch (Exception e) {
            throw new RuntimeException("유효하지 않은 비밀번호,아이디");
        }
    }

    @Transactional
    public User signUp(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("사용중인 아이디입니다.");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("사용중인 이메일입니다.");
        }
        user.setUserpassword(passwordEncoder.encode(user.getUserpassword())); // 비밀번호 암호화
        return userRepository.save(user);
    }
}
