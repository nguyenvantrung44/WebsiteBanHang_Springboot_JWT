package com.spring.banhang.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.banhang.server.dto.CategoryDto;
import com.spring.banhang.server.entity.Category;
import com.spring.banhang.server.repository.CategoryRepository;
import com.spring.banhang.server.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository reposi;

	@Override
	public List<CategoryDto> getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> entitys = reposi.findAll();
		List<CategoryDto> dtos = new ArrayList<CategoryDto>();
		for (Category category : entitys) {
			dtos.add(new CategoryDto(category.getId(),category.getName()));
		}
		return dtos;
	}

}
