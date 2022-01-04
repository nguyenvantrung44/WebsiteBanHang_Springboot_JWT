package com.spring.banhang.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.banhang.server.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
