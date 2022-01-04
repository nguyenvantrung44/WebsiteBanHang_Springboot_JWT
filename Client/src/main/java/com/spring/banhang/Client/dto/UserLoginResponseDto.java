package com.spring.banhang.Client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResponseDto {

	private String token;

	private int userId;

	private String userName;

	private boolean status;
}