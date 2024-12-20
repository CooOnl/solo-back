package com.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.proj.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	User findByUserpassword(String userpassword);
	User findByEmail(String email);
}
