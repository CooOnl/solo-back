package com.proj.jwt;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
//	private String secretKey="your_secret_key";	// 비밀키(변경 필요)
	
	//토큰 생성
	public String generateToken(String username) {
		SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		
		return Jwts.builder()
				.setSubject(username) // 사용자명
				.setIssuedAt(new Date()) //발행 시간
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1시간 설정
				.signWith(secretKey)
				.compact();
	}
	private final byte[] secretKey = "your-secret-key".getBytes();

	// 토큰 유효성 검사
	public boolean validateToken(String token) {
	    try {
	        Jwts.parserBuilder()
	            .setSigningKey(secretKey) // 비밀키 설정
	            .build()
	            .parseClaimsJws(token); // 토큰 검증
	        return true;
	    } catch (JwtException | IllegalArgumentException e) {
	        return false;
	    }
	}
	// 토큰에서 사용자 추출
	public String getUsernameFromToken(String token) {
	    return Jwts.parserBuilder()
	               .setSigningKey(secretKey) // 비밀키 설정
	               .build()
	               .parseClaimsJws(token)
	               .getBody()
	               .getSubject(); // 사용자 정보 (subject) 추출
	}

}
