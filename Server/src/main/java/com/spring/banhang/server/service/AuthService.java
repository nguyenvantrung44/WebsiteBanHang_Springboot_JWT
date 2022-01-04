package com.spring.banhang.server.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import com.spring.banhang.server.dto.LoginDto;
import com.spring.banhang.server.dto.UserLoginResponseDto;
import com.spring.banhang.server.dto.UserRegisterResponeDTO;

public interface AuthService {
	
	UserLoginResponseDto userLogin(LoginDto loginDto);
	
	UserRegisterResponeDTO insert(LoginDto dto);
	
	void sendVerificationEmail(UserRegisterResponeDTO dto) throws UnsupportedEncodingException, MessagingException;
	
	boolean verify(String verifiticationCode);
	
	void updateUser(int id);
}
