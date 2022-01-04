package com.spring.banhang.Client.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.banhang.Client.cartbean.Cart;
import com.spring.banhang.Client.cartbean.Item;
import com.spring.banhang.Client.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void insertOrderDetail(Cart cart, String token) {
		// TODO Auto-generated method stub		
		try {

			String authenticationBody = getBody(cart.getCart());
			HttpHeaders authenticationHeaders = getHeaders(token);
			HttpEntity<String> authenticationEntity = new HttpEntity<String>(authenticationBody,
					authenticationHeaders);
			
			restTemplate.exchange("http://localhost:8080/api/order",
					HttpMethod.POST, authenticationEntity, new ParameterizedTypeReference<String>() {
					});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private String getBody(final ArrayList<Item> arrayList) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(arrayList);
	}

	private HttpHeaders getHeaders(String accessToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer " + accessToken);
		return headers;
	}
}
