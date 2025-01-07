//package com.proj.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.proj.model.User;
//import com.proj.repository.UserRepository;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//		User user = userRepository.findByUsername(username)
//				.orElseThrow(()-> new UsernameNotFoundException("아이디를 찾을 수 없음" + username));
//		
//		return new CustomUserDetails(user);
//	}
//	
//	
//}
