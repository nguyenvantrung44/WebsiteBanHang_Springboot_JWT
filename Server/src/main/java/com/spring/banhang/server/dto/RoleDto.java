package com.spring.banhang.server.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleDto {


	private int id;
	
	@NotEmpty(message = "Vui lòng nhập tên!")
	@Length(min = 4, message = "Tên ít nhất 4 ký tự!")
	private String name;
	
	@NotEmpty(message = "Vui lòng nhập mô tả!")
	private String description;
	
}
