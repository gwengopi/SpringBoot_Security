package com.singtel.user.controller;


import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

	
	
	
	  @Override protected void configure(AuthenticationManagerBuilder auth) throws
	  Exception {
	  
	  auth.inMemoryAuthentication()
	  .withUser("user").password("user").roles("USER").and().
	  withUser(User.withUsername("admin").password("admin").roles("ADMIN"));
	  }
	  
	  @Override 
	  protected void configure(HttpSecurity http) throws Exception {
	  
	  http.authorizeRequests().
	  antMatchers("/user").hasAnyRole("ADMIN"); 
	  
	  }
	  @Bean public PasswordEncoder getPasswordEncoder() { return
	  NoOpPasswordEncoder.getInstance(); }
	 
	
	

	
}
