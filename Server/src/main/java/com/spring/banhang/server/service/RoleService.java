package com.spring.banhang.server.service;

import java.util.List;

import com.spring.banhang.server.dto.RoleDto;

public interface RoleService {
	void save(RoleDto dto);
	List<RoleDto> getAll();
	RoleDto getById(int id);
	void edit(RoleDto dto);
	void delete(int id);
}
