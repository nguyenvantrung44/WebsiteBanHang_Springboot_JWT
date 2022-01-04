package com.spring.banhang.Client.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.banhang.Client.dto.LoginDto;
import com.spring.banhang.Client.dto.UserLoginResponseDto;
import com.spring.banhang.Client.service.AuthService;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@Autowired
	HttpSession session;

	@GetMapping(path = "/login")
	public Object login(ModelMap map) {
		LoginDto logindto = new LoginDto();
		map.addAttribute("logindto", logindto);
		return "/auth/dangnhap";
	}
	
	@GetMapping("/showformdangki")
	public String showformdangKi() {
		return "/auth/dangki";
	}
	
	@GetMapping("/registersuccess")
	public String registerSuccess() {
		return "/auth/register_success";
	}
	
	@PostMapping(path = "/register")
	public Object register(@ModelAttribute("logindto") LoginDto logindto) {
		try {
			 authService.insert(logindto);
			return "redirect:/auth/registersuccess" ;
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/auth/showformdangki";
		}
	}
	
	@PostMapping(path = "/login")
	public String Login(@ModelAttribute("logindto") LoginDto logindto, Model model) {

		try {
			UserLoginResponseDto user = new UserLoginResponseDto();
			user = authService.userLogin(logindto);
			session.setAttribute("user", user);
			return "redirect:/home/trangchu" ;
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/auth/login";
		}

	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home/trangchu" ;
	}
	
	@GetMapping("/verifysuccess")
	public String verifySuccess() {
		return "/auth/activesuccess";
	}
	
	
	@GetMapping("/verify")
	public String verify(@RequestParam("code") String code) {
		try {
			authService.verify(code);
			return "redirect:/auth/verifysuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/home/trangchu";
		}
	}
	
}
