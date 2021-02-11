package com.shopping.myshopping.cart;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.myshopping.cart.dtos.CartDto;
import com.shopping.myshopping.cart.dtos.CreateCartDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {

	private final CartService cartService;
	
	@GetMapping
	public List<CartDto> list() {
		return cartService.list();
	}
	
	@PostMapping
	public CartDto create(@RequestBody CreateCartDto dto) {
		return cartService.create(dto);
	}
	
}
