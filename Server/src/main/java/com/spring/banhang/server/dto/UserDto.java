package com.spring.banhang.server.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	private String email;
	private String name;
	private LocalDate dateOfBirth;
	private String citizenIdentification;
	private String phoneNumber;
	private String address;
	private String roleDesc;
}
