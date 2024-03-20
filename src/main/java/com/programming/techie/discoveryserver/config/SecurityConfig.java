package com.programming.techie.discoveryserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
//@EnableWebFluxSecurity
public class SecurityConfig {

	@Value("${eureka.username}")
	private String username;
	
	@Value("${eureka.password}")
	private String password;
	
//	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
		authenticationManagerBuilder.inMemoryAuthentication()
			//.passwordEncoder(NoOpPasswordEncoder.getInstance())
			.withUser("EUREKA_USERNAME:eureka").password("EUREKA_PASSWORD:password")
			.authorities("USER");
	}
	
//	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.csrf().disable()
			.authorizeHttpRequests().anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}
}
