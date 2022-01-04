package com.spring.banhang.server.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Setter
@Getter
public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDate dateCreate;
	
	
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	private List<OrderDetail> orderDetails;


	public Order(LocalDate dateCreate) {
		super();
		this.dateCreate = dateCreate;
	}


	public Order(Integer id) {
		super();
		this.id = id;
	}
	
	
}
