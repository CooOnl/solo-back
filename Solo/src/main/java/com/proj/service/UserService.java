package com.proj.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proj.model.User;
import com.proj.repository.UserRepository;

@Service
public class UserService {

    private  UserRepository userRepository;
    
    
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Transactional
    public User signUp(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("사용중인 아이디입니다.");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("사용중인 이메일입니다.");
        }
        user.setUserpassword(passwordEncoder.encode(user.getUserpassword()));
        
        return userRepository.save(user);
    }
}
