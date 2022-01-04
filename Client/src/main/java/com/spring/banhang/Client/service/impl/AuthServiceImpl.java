package com.spring.banhang.Client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.banhang.Client.dto.LoginDto;
import com.spring.banhang.Client.dto.UserLoginResponseDto;
import com.spring.banhang.Client.dto.UserRegisterResponeDTO;
import com.spring.banhang.Client.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public UserRegisterResponeDTO insert(LoginDto dto) {
		// TODO Auto-generated method stub
		return restTemplate.postForEntity("http://localhost:8080/api/auth/register", dto, UserRegisterResponeDTO.class).getBody();
	}

	@Override
	public UserLoginResponseDto userLogin(LoginDto dto) {
		UserLoginResponseDto userLoginResponseDto = new UserLoginResponseDto();
		try {
			String authenticationBody = getBody(dto);
			HttpHeaders authenticationHeaders = getHeaders();

			HttpEntity<String> authenticationEntity = new HttpEntity<String>(authenticationBody, authenticationHeaders);

			ResponseEntity<UserLoginResponseDto> responseEntity = restTemplate.exchange(
					"http://localhost:8080/api/auth/login", HttpMethod.POST, authenticationEntity,
					new ParameterizedTypeReference<UserLoginResponseDto>() {
					});

			userLoginResponseDto.setToken(responseEntity.getBody().getToken());
			userLoginResponseDto.setUserId(responseEntity.getBody().getUserId());
			userLoginResponseDto.setUserName(responseEntity.getBody().getUserName());
			userLoginResponseDto.setStatus(responseEntity.getBody().isStatus());

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userLoginResponseDto;
	}

	private String getBody(final LoginDto user) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(user);
	}

	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return headers;
	}

	@Override
	public void verify(String verifiticationCode) {
		// TODO Auto-generated method stub
		 restTemplate.exchange("http://localhost:8080/api/auth/verify?code="+verifiticationCode,HttpMethod.GET,
				null,new ParameterizedTypeReference<String>() {
				});
	}

}
