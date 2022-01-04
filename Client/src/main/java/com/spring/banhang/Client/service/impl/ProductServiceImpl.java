package com.spring.banhang.Client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.banhang.Client.dto.ProductDto;
import com.spring.banhang.Client.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<ProductDto> getAllProduct() {
		// TODO Auto-generated method stub	
		ResponseEntity<List<ProductDto>> entity= restTemplate.exchange("http://localhost:8080/api/product",HttpMethod.GET,
				null,new ParameterizedTypeReference<List<ProductDto>>() {
				});
		
		return entity.getBody();
	}

	@Override
	public ProductDto getProductById(int id) {
		ResponseEntity<ProductDto> entity= restTemplate.exchange("http://localhost:8080/api/product/"+id,HttpMethod.GET,
				null,new ParameterizedTypeReference<ProductDto>() {
				});
		
		return entity.getBody();
	}
	


}
