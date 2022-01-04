package com.spring.banhang.server.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto {
	
	private Integer id;
	private String name;
	private LocalDate dateManufacture;
	private String unit;
	private String description;
	private long price;
	private int quantily;
	private String urlImage;
	private String status;
	private int supplierId;
	private int categoryId;	
}
