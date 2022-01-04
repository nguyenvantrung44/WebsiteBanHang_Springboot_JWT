package com.spring.banhang.server.dto;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserLoginResponseDto {
	private String token;
	private int userId;
	private String userName; 
	private boolean status;
}