//package com.proj.conf;
//
//import org.springframework.context.annotation.Bean; 
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import com.proj.service.UserService;
//
//@Configuration
//public class SecurityConfig {
//	
//	private UserService userService;
//	
//	public SecurityConfig(UserService userService) {
//		this.userService = userService;
//	}
//	
//	
//	
//	@Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // CSRF 비활성화 (REST API에 필요 없음)
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(
//                                "/auth/**",
//                                "/swagger-ui/**", // Swagger UI 경로
//                                "/v3/api-docs/**", // OpenAPI 경로
//                                "/swagger-ui.html", // Swagger HTML
//                                "/login",
//                                "/register",
//                                "/board"
//                        ).permitAll() // 인증 없이 접근 가능한 경로
//                        .anyRequest().authenticated() // 나머지 요청은 인증 필요
//                )
//                .httpBasic(httpBasic -> httpBasic.disable()); // Basic 인증 비활성화
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder =
//                http.getSharedObject(AuthenticationManagerBuilder.class);
//
//        // Explicitly configure AuthenticationManager
//        authenticationManagerBuilder.userDetailsService(userService)
//                .passwordEncoder(passwordEncoder());
//
//        return authenticationManagerBuilder.build(); // Ensure the bean is created
//    }
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
