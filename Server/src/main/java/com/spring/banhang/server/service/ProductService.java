package com.spring.banhang.server.service;

import java.util.List;

import com.spring.banhang.server.dto.ProductDto;

public interface ProductService {
	
	List<ProductDto> getAllProduct();
	ProductDto getProductById(int id);
}
