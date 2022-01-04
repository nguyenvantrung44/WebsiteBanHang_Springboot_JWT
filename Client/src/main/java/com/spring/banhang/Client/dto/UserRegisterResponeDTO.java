package com.spring.banhang.Client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegisterResponeDTO {
	
	private int id;
	private String email;
	private String verifitication;
}
