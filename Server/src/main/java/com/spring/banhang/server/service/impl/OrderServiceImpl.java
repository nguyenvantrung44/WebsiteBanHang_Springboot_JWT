package com.spring.banhang.server.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.banhang.server.entity.Order;
import com.spring.banhang.server.repository.OrderRepository;
import com.spring.banhang.server.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository reposi;

	@Override
	public int insertOrder() {
		// TODO Auto-generated method stub
		return reposi.save(new Order(LocalDate.now())).getId();
	}

}
