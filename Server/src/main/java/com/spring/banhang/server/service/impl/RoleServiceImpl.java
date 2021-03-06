package com.spring.banhang.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.banhang.server.dto.RoleDto;
import com.spring.banhang.server.entity.Role;
import com.spring.banhang.server.repository.RoleRepository;
import com.spring.banhang.server.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService{

	private RoleRepository roleRepository;
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public List<RoleDto> getAll() {
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		try {
			List<Role> entities = roleRepository.findAll();
			for (Role role: entities) {
				dtos.add(new RoleDto(
						role.getId(), 
						role.getName(),
						role.getDescription()));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public RoleDto getById(int id) {
		Role entity = roleRepository.findById(id).get();
		return new RoleDto(
				entity.getId(), 
				entity.getName(),
				entity.getDescription());
	}
	
	public void save(RoleDto dto) {
		Role entity = new Role();
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		
		roleRepository.save(entity);
	}

	public void edit(RoleDto dto) {
		Role entity = roleRepository.findById(dto.getId()).get();
		if(entity != null) {
			entity.setName(dto.getName());
			entity.setDescription(dto.getDescription());
			
			roleRepository.save(entity);
		}
	}

	@Override
	public void delete(int id) {
		roleRepository.deleteById(id);
	}
}
