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
import com.spring.banhang.Client.dto.UserDto;
import com.spring.banhang.Client.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public UserDto getByEmail(String email, String token) {
		// TODO Auto-generated method stub
		HttpHeaders authenticationHeaders = getHeaders(token);
		HttpEntity<String> authenticationEntity = new HttpEntity<String>(
				authenticationHeaders);
		ResponseEntity<UserDto> responseEntity = restTemplate.exchange("http://localhost:8080/api/user/email/" + email,
				HttpMethod.GET, authenticationEntity, new ParameterizedTypeReference<UserDto>() {
				});
		
		return responseEntity.getBody();
	}
	
	private HttpHeaders getHeaders(String accessToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+accessToken);
		return headers;
	}

}
