package com.spring.banhang.Client.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {

	private int id;
	private String email;
	private String name;
	private LocalDate dateOfBirth;
	private String citizenIdentification;
	private String phoneNumber;
	private String address;
	private boolean status;
	private int roleId;
	private String roleDesc;
	public UserDto(int id, String email, String name, LocalDate dateOfBirth, String citizenIdentification,
			String phoneNumber, String address, String roleDesc) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.citizenIdentification = citizenIdentification;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.roleDesc = roleDesc;
	}	
}
