package com.spring.banhang.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.banhang.server.service.CategoryService;

@RestController
@RequestMapping("api/category")
public class CategoryController {

	@Autowired
	private CategoryService catService;
	
	@GetMapping("")
	public Object getAllCategory() {
		try {
			return new ResponseEntity<Object>(catService.getAllCategory(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}
