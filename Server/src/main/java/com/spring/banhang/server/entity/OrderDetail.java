package com.spring.banhang.server.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orderdetails")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@EmbeddedId
	private OrderId orderId;
	
	@ManyToOne
	@JoinColumn(name = "product_id", insertable = false, updatable = false)
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", insertable = false, updatable = false)
	private Order order;

	private int quantily;
	private float price;
	

}