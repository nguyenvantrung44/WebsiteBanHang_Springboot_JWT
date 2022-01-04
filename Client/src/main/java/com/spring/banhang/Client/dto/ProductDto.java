package com.spring.banhang.Client.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
