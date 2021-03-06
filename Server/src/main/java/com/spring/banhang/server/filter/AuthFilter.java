package com.spring.banhang.server.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;


public class AuthFilter extends BasicAuthenticationFilter{
	
	private UserDetailsService userDetailsService;

	public AuthFilter(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
		super(authenticationManager);
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		if(request.getServletPath().startsWith("/api/admin/auth/login")) {
			chain.doFilter(request, response);
			return;
		}
		
		if(request.getServletPath().startsWith("/api/admin/auth/register")) {
			chain.doFilter(request, response);
			return;
		}
		
		if(request.getServletPath().startsWith("/api/auth/register")) {
			chain.doFilter(request, response);
			return;
		}
		
		if(request.getServletPath().startsWith("/api/auth/login")) {
			chain.doFilter(request, response);
			return;
		}
		
		if(request.getServletPath().startsWith("/api/auth/verify")) {
			chain.doFilter(request, response);
			return;
		}

		if(request.getServletPath().startsWith("/api/product")) {
			chain.doFilter(request, response);
			return;
		}
		
		if(request.getServletPath().startsWith("/api/category")) {
			chain.doFilter(request, response);
			return;
		}
		
		// B1. L???Y TOKEN T??? REQUEST
		String tokenHeader = request.getHeader("Authorization");
		
		if(tokenHeader != null && !tokenHeader.isEmpty() && tokenHeader.startsWith("Bearer ")) {
			// l???y token chu???n
			String token = tokenHeader.replace("Bearer ", "");
			// GI???I M?? TOKEN L???Y EMAIL
			String email = Jwts.parser()
			.setSigningKey("ABC_EGH")
			.parseClaimsJws(token)
			.getBody()
			.getSubject();
			
			// G???I PH????NG TH???C L???Y TH??NG TIN USER (UserDetailDTO)
			UserDetails userDetails = userDetailsService.loadUserByUsername(email);
			
			// email, pw: null, quy???n
			Authentication authentication = 
					new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			
			// SET TH??NG TIN USER V??O CONTEXT => ????? PH??N QUY???N
			SecurityContextHolder.getContext().setAuthentication(authentication);
			chain.doFilter(request, response);
		}
		else {
			response.sendError(401, "Ch??a ????ng nh???p!");
		}
		
	}
}
