package com.spring.banhang.Client.service;

import com.spring.banhang.Client.dto.LoginDto;
import com.spring.banhang.Client.dto.UserLoginResponseDto;
import com.spring.banhang.Client.dto.UserRegisterResponeDTO;

public interface AuthService {
	UserLoginResponseDto userLogin(LoginDto dto);
	UserRegisterResponeDTO insert(LoginDto dto);
	void verify(String verifiticationCode);
}
