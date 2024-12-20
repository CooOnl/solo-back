package com.proj.jwt;




import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
    		HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
//    	 String path = request.getRequestURI();
    	 
//    	 if (path.equals("/apis/signin")) {
//    	        filterChain(response, response);
//    	        return;
//    	    }
    	 
        // Authorization 헤더에서 JWT 가져오기
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(5); // "Bearer " 제외한 부분 추출

            try {
                if (jwtUtil.isTokenExpired(token)) {
                    throw new RuntimeException("Token expired");
                }

                String username = jwtUtil.extractUsername(token);
                // SecurityContext에 인증 정보 설정
                SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(username, null, null)
                );
            } catch (Exception e) {
                // 인증 실패 시 처리
                SecurityContextHolder.clearContext();
            }
        }

//        filterChain.doFilter(request, response);
    }
}
