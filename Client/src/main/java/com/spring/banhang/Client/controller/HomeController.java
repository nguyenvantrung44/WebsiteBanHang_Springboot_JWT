package com.spring.banhang.Client.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.banhang.Client.cartbean.Cart;
import com.spring.banhang.Client.cartbean.Item;
import com.spring.banhang.Client.service.CategoryService;
import com.spring.banhang.Client.service.ProductService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private ProductService pService;
	
	@Autowired
	private CategoryService catService;
	
	@Autowired
	HttpSession session;

	
	@GetMapping(path = "/trangchu")
	public Object home(ModelMap map, HttpServletRequest request) {
		session = request.getSession();
		Cart cart = null;
		Object objCart = session.getAttribute("cart"); // Lấy cart từ jsp

		if (objCart != null) {
			cart = (Cart) objCart;
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		map.addAttribute("listProduct", pService.getAllProduct());
		map.addAttribute("listCategory", catService.getAllCategory());
		return "/home/TrangChuView";
	}
	
	@GetMapping(path = "/productDetail")
	public Object productDetail(ModelMap map, @RequestParam("productId") int id) {
		map.addAttribute("product", pService.getProductById(id));
		return "/home/ThongTinSanPhamView";
	}
	
	@GetMapping(path = "/showCart")
	public Object showcart() {
		return "/home/CartView";
	}
	
	@PostMapping(path = "/addToCart")
	public Object addToCart(@RequestParam("action") String action, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (action != null && !action.equals("")) {
			if (action.equals("add")) {
				addItem(request, response);
				return "redirect:/home/showCart";
			} else if (action.equals("update")) {
				updateQuantily(request, response);
				return "/home/CartView";
			} else if (action.equals("delete")) {
				deleteItem(request, response);
				return "redirect:/home/showCart";
			}
		}
		return "/home/ChiTietDonHangView";
	}	
	
	public void addItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		String url = request.getParameter("urlImage");
		long price = Long.valueOf(request.getParameter("price"));
		int quantily = Integer.valueOf(request.getParameter("quantily"));

		session = request.getSession();
		Cart cart = null;
		Object objCart = session.getAttribute("cart");
		
		if (objCart != null) {
			cart = (Cart) objCart;
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		int quantilyInStock = 0;
		try {
			if (pService.getProductById(id).getQuantily() != 0) {
				quantilyInStock += pService.getProductById(id).getQuantily();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(id);
		cart.addItem(new Item(id, name, url, price, quantily, quantilyInStock));
		session.setAttribute("cart", cart);
	}
	
	public void updateQuantily(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		int quantily = Integer.valueOf(request.getParameter("quantily"));

		session = request.getSession();
		Cart cart = null;
		Object objCart = session.getAttribute("cart");
		if (objCart != null) {
			cart = (Cart) objCart;
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		cart.updateItem(cart.getItemById(id), quantily);
	}

	public void deleteItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		session = request.getSession();
		Cart cart = null;
		Object objCart = session.getAttribute("cart");
		if (objCart != null) {
			cart = (Cart) objCart;
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		cart.deleteItem(cart.getItemById(id));
	}
	
}
