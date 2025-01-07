package com.proj.model;

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		
		private String username;
		
		private String userpassword;
		
		private String name;
		
		private String email;
		
		private String userbirth;
		
		private String usernumber;
		
		private String role;
		

//	    @PrePersist
//	    public void prePersist() {
//	        // 생략된 필드에 값 설정 (예: 가입 시 생성일)
//	        if (this.birth == null) {
//	            this.birth = "1990-01-01"; // 예시 기본 값
//	        }
//	    }
}
