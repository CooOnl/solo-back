//package com.proj.jwt;
//
//import java.util.Date;
//
//import javax.crypto.SecretKey;
//
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//
//@Component
//public class JwtUtil {
//
//	
//	public String generateToken(String username) {
//		// 비밀 키를 문자열로 지정한 경우 SecretKeySpec 사용
////		String secretKeyString = "your-secret-key";
//		SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//		
//		return Jwts.builder()
//				.setSubject(username)
//				.setIssuedAt(new Date())
//				.setExpiration(new Date(System.currentTimeMillis()+1000 * 60 * 60)) // 1시간
//				.signWith(secretKey)
//				.compact();
//	}
//}
