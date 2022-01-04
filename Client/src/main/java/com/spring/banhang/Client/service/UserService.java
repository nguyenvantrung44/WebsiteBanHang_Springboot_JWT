package com.spring.banhang.Client.service;

import com.spring.banhang.Client.dto.UserDto;

public interface UserService {
	UserDto getByEmail(String email, String token);
}
