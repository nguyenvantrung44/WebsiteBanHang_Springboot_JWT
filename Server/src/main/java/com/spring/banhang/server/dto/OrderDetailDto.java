package com.spring.banhang.server.dto;

import com.spring.banhang.server.entity.OrderId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetailDto {
	private OrderId orderId;
	private int quantily;
	private float price;
}
