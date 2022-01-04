package com.spring.banhang.server.dto;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailDto extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private LocalDate dateOfBirth;
	private String citizenIdentification;
	private String phoneNumber;
	private String address;	
	private boolean status;

	public UserDetailDto(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public UserDetailDto(String username, String password, Collection<? extends GrantedAuthority> authorities,
			String name, LocalDate dateOfBirth, String citizenIdentification, String phoneNumber, String address,
			Boolean status) {
		super(username, password, authorities);
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.citizenIdentification = citizenIdentification;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.status = status;
	}
	
}
