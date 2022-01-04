package com.spring.banhang.server.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product implements Serializable {

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
	
	@Column(columnDefinition = "nvarchar(255)")
	@NotNull(message = "Tên sản phẩm không được để rỗng")
	@Length(min = 2, max = 20, message = "Tên sản phẩm từ 2 đến 20 kí tự")
	private String name;
	
	private LocalDate dateManufacture;
	
	@Column(columnDefinition = "nvarchar(255)")
	@NotNull(message = "Đơn vị tính không được bỏ trống")
	private String unit;
	
	@Column(columnDefinition = "nvarchar(255)")
	@NotNull(message = "Mô tả không được để rỗng")
	@Length(min = 2, max = 50, message = "Tên sản phẩm từ 2 đến 50 kí tự")
	private String description;
	
	private long cost;
	
	private long price;
	
	private int quantily;
	
	private String urlImage;
	
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id", insertable = false, updatable = false)
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name = "category_id", insertable = false, updatable = false)
	private Category category;

	public Product(Integer id) {
		super();
		this.id = id;
	}

	
}
