package com.spring.banhang.server.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.banhang.server.dto.OrderDetailDto;
import com.spring.banhang.server.dto.post.PostCart;
import com.spring.banhang.server.entity.Order;
import com.spring.banhang.server.entity.OrderDetail;
import com.spring.banhang.server.entity.OrderId;
import com.spring.banhang.server.entity.Product;
import com.spring.banhang.server.repository.OrderDetailRepository;
import com.spring.banhang.server.service.OrderDetailService;
import com.spring.banhang.server.service.OrderService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	
	@Autowired
	private OrderService oService;
	
	@Autowired
	private OrderDetailRepository oDetailReposi;

	@Override
	public void insertOrderDetail(ArrayList<PostCart> carts) {
		// TODO Auto-generated method stub
		int orderId = oService.insertOrder();
		
		OrderDetailDto dto = new OrderDetailDto();
		OrderDetail detail = new OrderDetail();
		OrderId id = new OrderId();
		
		id.setOrder_id(orderId);
		for (PostCart postCart : carts) {
			
			id.setProduct_id(postCart.getId());
			dto = new OrderDetailDto(id, postCart.getQuantily(), postCart.getPrice());
			
			detail.setOrderId(dto.getOrderId());
			detail.setProduct(new Product(postCart.getId()));
			detail.setOrder(new Order(orderId));
			detail.setQuantily(dto.getQuantily());
			detail.setPrice(dto.getPrice());
			
			oDetailReposi.save(detail);
		}
		
	}

}
