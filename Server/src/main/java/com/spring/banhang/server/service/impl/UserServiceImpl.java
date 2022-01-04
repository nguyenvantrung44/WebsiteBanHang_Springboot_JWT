package com.spring.banhang.server.service.impl;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.spring.banhang.server.dto.UserDto;
import com.spring.banhang.server.dto.post.PostUser;
import com.spring.banhang.server.entity.User;
import com.spring.banhang.server.repository.UserRepository;
import com.spring.banhang.server.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<UserDto> getAll() {
		List<UserDto> dtos = userRepository.findAllJoin();
		return dtos;
	}

	@Override
	public void insert(PostUser dto) {
		String hashed = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
		// MAPPING USER DTO SANG USER ENTITY
		User entity = new User();
		entity.setEmail(dto.getEmail());
		entity.setPassword(hashed);
		entity.setName(dto.getEmail().split("@")[0]);
		entity.setRoleId(2);

		userRepository.save(entity);
	}

	@Override
	public UserDto getByEmail(String email) {
		User entity = userRepository.findByEmail(email);
		UserDto dto = new UserDto(entity.getId(), entity.getEmail(), entity.getName(), entity.getDateOfBirth(),
				entity.getCitizenIdentification(), entity.getPhoneNumber(), entity.getAddress(),
				entity.getRole().getDescription());
		return dto;
	}

	@Override
	public UserDto getById(int id) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id).orElse(null);
		UserDto dto = new UserDto(user.getId(), user.getEmail(), user.getName(), user.getDateOfBirth(),
				user.getCitizenIdentification(), user.getPhoneNumber(), user.getAddress(), user.getRole().getDescription());

		return dto;
	}

}
