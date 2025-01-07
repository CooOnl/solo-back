package com.proj.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proj.model.User;
import com.proj.repository.UserRepository;

@Service
public class UserService {

    private  UserRepository userRepository;
    
    
    

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        
    }
    
    @Transactional
    public User signUp(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("사용중인 아이디입니다.");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("사용중인 이메일입니다.");
        }
        
        
        return userRepository.save(user);
        
    }
 // 사용자 인증 (로그인)
    public User authenticate(String username, String userpassword) {
        // 사용자명으로 사용자 정보 조회
        User user = userRepository.findByUsername(username);

        // 사용자 존재 여부와 비밀번호 확인
        if (user != null && user.getUserpassword().equals(userpassword)) {
            return user;  // 인증 성공
        }
        return null;  // 인증 실패
    }
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userRepository.findByUsername(username); 
    }
    
    
}
