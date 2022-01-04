package com.spring.banhang.server.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.spring.banhang.server.dto.LoginDto;
import com.spring.banhang.server.dto.UserLoginResponseDto;
import com.spring.banhang.server.dto.UserRegisterResponeDTO;
import com.spring.banhang.server.entity.User;
import com.spring.banhang.server.repository.UserRepository;
import com.spring.banhang.server.service.AuthService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.bytebuddy.utility.RandomString;

@Service
public class AuthServiceImpl implements AuthService {

	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JavaMailSender mailSender;

	public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
	}
	
	@Override
	public UserRegisterResponeDTO insert(LoginDto dto) {

		String hash = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());

		User user = new User();
		user.setEmail(dto.getEmail());
		user.setPassword(hash);
		user.setRoleId(2);
		user.setStatus(false);

		String randomCode = RandomString.make(64);
		user.setVerificationCode(randomCode);

		userRepository.save(user);
		return new UserRegisterResponeDTO(user.getId(), user.getEmail(), randomCode);

	}

	@Override
	public void sendVerificationEmail(UserRegisterResponeDTO dto)
			throws UnsupportedEncodingException, MessagingException {
		// TODO Auto-generated method stub
		String subject = "Vui lòng xác minh email của bạn !!!";
		String senderName = "Thegioixedien";
		String mailContent = "<p>Gửi " + dto.getEmail().split("@")[0] + ",</p>";
		mailContent += "<p>Vui lòng click vào link bên dưới để xác minh việc đăng kí:</p>";

		String verifyURL =  "http://localhost:7070/auth/verify?code=" + dto.getVerifitication();

		mailContent += "<h3><a href=\""+ verifyURL + "\">VERIFY</a></h3>";
		mailContent += "<p>Thank you<br> The Thegioixedien";

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom("vantrung44.it@gmail.com", senderName);
		helper.setTo(dto.getEmail());
		helper.setSubject(subject);
		helper.setText(mailContent, true);

		mailSender.send(message);
	}

	@Override
	public UserLoginResponseDto userLogin(LoginDto loginDto) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));

		// Create token
		Date now = new Date();
		String token = Jwts.builder().setSubject(loginDto.getEmail()).setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + 86400000L)).signWith(SignatureAlgorithm.HS512, "ABC_EGH")
				.compact();

		// Get user information
		User entity = userRepository.findByEmail(loginDto.getEmail());
		// Convert entity to dto
		UserLoginResponseDto dto = new UserLoginResponseDto();
		dto.setToken(token);
		dto.setUserId(entity.getId());
		dto.setUserName(entity.getEmail());
		dto.setStatus(entity.isStatus());
		return dto;
	}

	@Override
	public boolean verify(String verifiticationCode) {
		// TODO Auto-generated method stub
		User user = userRepository.findByVerificationCode(verifiticationCode);
		if(user == null || user.isStatus()) {
			return false;
		} else {
			updateUser(user.getId());
			return true;
		}
	}

	@Override
	public void updateUser(int id) {
		// TODO Auto-generated method stub
		User u = userRepository.findById(id).orElse(null);
		u.setStatus(true);
		u.setVerificationCode(null);

		userRepository.save(u);
	}

}
