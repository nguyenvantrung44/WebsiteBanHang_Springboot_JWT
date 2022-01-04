package com.spring.banhang.Client.service;

import com.spring.banhang.Client.cartbean.Cart;

public interface OrderService {
	void insertOrderDetail(Cart cart, String token);
}
