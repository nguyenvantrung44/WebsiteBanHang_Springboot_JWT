package com.spring.banhang.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.banhang.server.filter.AuthFilter;


@Configuration
@EnableWebSecurity
@Order(1)
public class UserSercurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	public UserSercurityConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;

	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		
		http.csrf().disable() // TẮT CHỨC NĂNG CHỐNG TẤN CÔNG GIẢ MẠO REQUEST
		.antMatcher("/api/**") 
		.authorizeRequests()
		.antMatchers("/api/auth/register").permitAll()
		.antMatchers("/api/auth/login").permitAll()
		.antMatchers("/api/user")
		.authenticated();
		
//		.antMatcher("/api/**") 
//		.authorizeRequests()
//		.antMatchers("/api/user")
//		.hasAnyRole("USER")
//		.antMatchers("/api/auth/login")
//		.permitAll()
//		.anyRequest()
//		.authenticated();
		
		http.addFilter(new AuthFilter(authenticationManager(), userDetailsService));
		
		// KHÔNG SỬ DỤNG SESSION
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}

