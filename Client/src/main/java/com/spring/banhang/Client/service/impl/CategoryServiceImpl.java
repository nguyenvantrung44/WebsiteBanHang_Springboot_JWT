package com.spring.banhang.Client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.spring.banhang.Client.dto.CategoryDto;
import com.spring.banhang.Client.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
		
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<CategoryDto> getAllCategory() {
		// TODO Auto-generated method stub	
		ResponseEntity<List<CategoryDto>> entity= restTemplate.exchange("http://localhost:8080/api/category",HttpMethod.GET,
				null,new ParameterizedTypeReference<List<CategoryDto>>() {
				});
		
		return entity.getBody();
	}
}
