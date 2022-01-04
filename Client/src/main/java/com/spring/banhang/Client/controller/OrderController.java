package com.spring.banhang.Client.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.banhang.Client.cartbean.Cart;
import com.spring.banhang.Client.cartbean.Item;
import com.spring.banhang.Client.dto.UserDto;
import com.spring.banhang.Client.dto.UserLoginResponseDto;
import com.spring.banhang.Client.service.OrderService;
import com.spring.banhang.Client.service.UserService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	HttpSession session;
	
	
	@GetMapping("")
	public String order(ModelMap map) {
		UserDto userDto = new UserDto();
		UserLoginResponseDto responseDto = (UserLoginResponseDto) session.getAttribute("user");
		
		if(responseDto == null) {
			return "redirect:/auth/login";
		}else {
			userDto = userService.getByEmail(responseDto.getUserName(),responseDto.getToken());
			map.addAttribute("kh", userDto);
			return "/user/ThanhToanView";
		}
	} 
	
	@PostMapping("confirmOrder")
	public String confirmOrder() {
		UserLoginResponseDto responseDto = (UserLoginResponseDto) session.getAttribute("user");
		
		if(responseDto == null) {
			return "redirect:/auth/login";
		}else {
			Cart cart = null;
			Object objCart = session.getAttribute("cart");
			cart = (Cart) objCart;
			Cart c = new Cart();
			for(Item item : cart.getCart()) {
				c.addItem(new Item(item.getId(), item.getPrice(), item.getQuantily()));
			}
			orderService.insertOrderDetail(c, responseDto.getToken());
			session.removeAttribute("cart");
			return "redirect:/home/trangchu";
		}
	}

}
