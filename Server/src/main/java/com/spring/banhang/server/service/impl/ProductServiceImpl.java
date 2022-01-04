package com.spring.banhang.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.banhang.server.dto.ProductDto;
import com.spring.banhang.server.entity.Product;
import com.spring.banhang.server.repository.ProductRepository;
import com.spring.banhang.server.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository reposi;

	@Override
	public List<ProductDto> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> entitys = reposi.findAll();
		List<ProductDto> dtos = new ArrayList<ProductDto>();
		for (Product p : entitys) {
			dtos.add(new ProductDto(p.getId(), p.getName(), p.getDateManufacture(), p.getUnit(), p.getDescription(),
					 p.getPrice(), p.getQuantily(), p.getUrlImage(), p.getStatus(), p.getSupplier().getId(),
					p.getCategory().getId()));
		}

		return dtos;
	}

	@Override
	public ProductDto getProductById(int id) {
		// TODO Auto-generated method stub
		Product p = reposi.findById(id).orElse(null);
		ProductDto dto = new ProductDto(p.getId(), p.getName(), p.getDateManufacture(), p.getUnit(), p.getDescription(),
				 p.getPrice(), p.getQuantily(), p.getUrlImage(), p.getStatus(), p.getSupplier().getId(),
				p.getCategory().getId()) ;
		return dto;
	}

}
