package com.spring.banhang.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.banhang.server.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
