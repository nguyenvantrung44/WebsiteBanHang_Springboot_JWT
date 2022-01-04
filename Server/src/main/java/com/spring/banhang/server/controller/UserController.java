package com.spring.banhang.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.banhang.server.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("")
	public Object getAllUser() {
		try {
			return new ResponseEntity<Object>(userService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{id}")
	public Object getUserById(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Object>(userService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/email/{email}")
	public Object getUserByEmail(@PathVariable("email") String email) {
		try {
			return new ResponseEntity<Object>(userService.getByEmail(email), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

}
