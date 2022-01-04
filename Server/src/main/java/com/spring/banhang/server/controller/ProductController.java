package com.spring.banhang.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.banhang.server.service.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("")
	public Object getAllProduct() {
		try {
			return new ResponseEntity<Object>(productService.getAllProduct(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("{id}")
	public Object getProductById(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Object>(productService.getProductById(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("KHông tìm thấy sản phẩm !",HttpStatus.BAD_REQUEST);
	}
	
}
