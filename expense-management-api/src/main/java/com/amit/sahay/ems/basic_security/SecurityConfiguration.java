package com.amit.sahay.ems.basic_security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration {

	private CustomUserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/api/users/register").permitAll();			
			auth.anyRequest().authenticated();
		});
		httpSecurity.csrf(csrf->csrf.disable());
		
		httpSecurity.formLogin(Customizer.withDefaults());
		httpSecurity.httpBasic(Customizer.withDefaults());
		return httpSecurity.build();
	}
}
