package com.spring.banhang.Client.service;

import java.util.List;

import com.spring.banhang.Client.dto.ProductDto;


public interface ProductService {
	
	List<ProductDto> getAllProduct();
	ProductDto getProductById(int id);
}
