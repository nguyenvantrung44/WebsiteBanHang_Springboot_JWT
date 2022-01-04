package com.spring.banhang.server.service;

import java.util.ArrayList;

import com.spring.banhang.server.dto.post.PostCart;

public interface OrderDetailService {
	void insertOrderDetail(ArrayList<PostCart> carts);
}
