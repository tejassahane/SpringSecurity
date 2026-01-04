package com.kodnest.app.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	
	

	@Bean
	public InMemoryUserDetailsManager userDetails() {
		UserDetails user = User.withUsername("user").password("{noop}user123").roles("user").build();
		UserDetails admin = User.withUsername("admin").password("{noop}admin123").roles("admin").build();

		InMemoryUserDetailsManager imudm = new InMemoryUserDetailsManager(user,admin);
		return imudm;
	}
	
	@Bean
	public SecurityFilterChain filChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf -> csrf.disable());
		
		http.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/api/show").hasRole("user").requestMatchers("/api/dontshow").hasRole("admin").anyRequest().authenticated();
		});
		
		http.formLogin(Customizer.withDefaults());
		return http.build();
	}
}
