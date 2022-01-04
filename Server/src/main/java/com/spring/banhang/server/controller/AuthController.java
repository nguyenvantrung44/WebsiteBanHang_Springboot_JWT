package com.spring.banhang.server.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.banhang.server.dto.LoginDto;
import com.spring.banhang.server.dto.UserRegisterResponeDTO;
import com.spring.banhang.server.service.AuthService;

@RestController
@RequestMapping("api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("login")
	public Object post(@Valid @RequestBody LoginDto dto) {
		try {

			return new ResponseEntity<Object>(authService.userLogin(dto), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Error"+e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("register")
	public Object postRegister(@Valid @RequestBody LoginDto dto) {
		try {
			UserRegisterResponeDTO dtoRegister = authService.insert(dto);
			authService.sendVerificationEmail(dtoRegister);
			return new ResponseEntity<Object>(dtoRegister, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("verify")
	public Object verifyAccount(@Param("code") String code) {
		try {
			authService.verify(code);
			return new ResponseEntity<Object>("Verify Success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Error"+e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

}
