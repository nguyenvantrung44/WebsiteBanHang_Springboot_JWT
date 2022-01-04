package com.spring.banhang.server.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "roles") // ÁNh xạ lớp Role với bảng roles trong db
@Data
public class Role {

	@Id // Khai báo đây khóa chính
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Khai báo khóa chính tăng tự động
	private int id;
	
	@Column(name = "name") // Ánh xạ thuộc tính name đến cột name trong table
	private String name;
	
	private String description;
	
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	private List<User> users;
	
}

