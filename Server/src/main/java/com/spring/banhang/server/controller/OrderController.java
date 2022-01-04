package com.spring.banhang.server.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.banhang.server.dto.post.PostCart;
import com.spring.banhang.server.service.OrderDetailService;

@RestController
@RequestMapping("api/order")
public class OrderController {

	@Autowired
	private OrderDetailService oDetailService;

	@PostMapping("")
	public ResponseEntity<String> order(@RequestBody ArrayList<PostCart> carts) {
		try {
			oDetailService.insertOrderDetail(carts);
			return new ResponseEntity<String>("Thành công !", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
}
