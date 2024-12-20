package com.proj.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    //private final String secret = "jwt_secret_key"; // application.properties의 키와 일치해야 함
    private final long expiration = 3600000; // 1시간
    private static final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // 토큰 생성
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(secretKey)
                .compact();
    }

    // 토큰에서 사용자 이름 추출
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    // 토큰 만료 여부 확인
    public boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    // 토큰 검증
    public boolean validateToken(String token, String username) {
        return username.equals(extractUsername(token)) && !isTokenExpired(token);
    }

    // Claims 추출
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)	//서명 키 설정?
                .build()	
                .parseClaimsJws(token)	//JWT 파싱
                .getBody();	// Claims 반환
    }
}

