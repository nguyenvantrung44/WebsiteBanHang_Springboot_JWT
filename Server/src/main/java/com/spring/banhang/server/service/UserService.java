package com.spring.banhang.server.service;

import java.util.List;

import com.spring.banhang.server.dto.UserDto;
import com.spring.banhang.server.dto.post.PostUser;

public interface UserService {
	void insert(PostUser dto);
	List<UserDto> getAll();
	UserDto getById(int id);
	UserDto getByEmail(String email);
}
