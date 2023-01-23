package com.springboot.myfirstwebapp.security;

import java.util.function.Function;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	//Ldap or database we use to store username and password. but 
	//here we make inmemory 

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		UserDetails userDetails1 = createNewUser("nishchal", "nishchal");
		UserDetails userDetails2 = createNewUser("aarav", "aarav");
		return new InMemoryUserDetailsManager(userDetails1,userDetails2 ) ;
		
	}
	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input->passwordEncorder().encode(input);
		
		UserDetails userDetails=User.builder()
		.passwordEncoder(passwordEncoder)		
		.username(username)
		.password(password)
		.roles("USER", "ADMIN")
		.build();
		return userDetails;
	}
	@Bean
	public PasswordEncoder passwordEncorder() {
		return new BCryptPasswordEncoder();
	}
	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
		auth ->auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		return http.build();
	}

}
