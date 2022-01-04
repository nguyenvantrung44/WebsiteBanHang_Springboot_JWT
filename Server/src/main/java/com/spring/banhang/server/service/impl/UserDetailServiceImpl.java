package com.spring.banhang.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.banhang.server.dto.UserDetailDto;
import com.spring.banhang.server.entity.Role;
import com.spring.banhang.server.entity.User;
import com.spring.banhang.server.repository.UserRepository;


@Service
@Transactional(rollbackOn = Exception.class)
public class UserDetailServiceImpl implements UserDetailsService{
	
	private UserRepository userRepository;
	
	public UserDetailServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) 
			throws UsernameNotFoundException {
		
		// B1. Gọi hàm truy vấn email
		User user = userRepository.findByEmail(email);
		// sv trả bad rq lỗi 400
		if(user == null) throw new UsernameNotFoundException("Email không tồn tại!");
		
		// B2. Truy vấn db lấy roleName 
//		Role role = roleRepository.findById(user.getRoleId()).get();
		Role role = user.getRole();
		
		// B3. Tạo danh sách chứa roleName
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		// 1 list chưa role Name
		authorities.add(new SimpleGrantedAuthority(role.getName()));
		
		// password: 123456
		UserDetailDto dto = new UserDetailDto(email, user.getPassword(), authorities);
		
		dto.setName(user.getName());
		
		// B4. Trả về đối tượng UserDetail chứa email, pass, roleName
		return dto;
	}

}
