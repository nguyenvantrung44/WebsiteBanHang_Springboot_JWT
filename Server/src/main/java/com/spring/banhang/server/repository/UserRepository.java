package com.spring.banhang.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.banhang.server.dto.UserDto;
import com.spring.banhang.server.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT new com.spring.banhang.server.dto.UserDto("
			+ "u.id, u.email, u.name, u.dateOfBirth, u.citizenIdentification,\r\n"
			+ "			u.phoneNumber, u.address, r.description) FROM User u JOIN Role r ON u.roleId = r.id")
	public List<UserDto> findAllJoin();

	public User findByEmail(String email);
	
	
	@Query("SELECT u from User u WHERE u.verificationCode = ?1")
	public User findByVerificationCode(String code);
}
