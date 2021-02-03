package com.shopping.myshopping.cart;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.myshopping.cart.dto.CreateCartDto;
import com.shopping.myshopping.cart.entities.CartEntity;
import com.shopping.myshopping.client.exceptions.ClientNotFoundException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {

	private final CartService cartService;
	
	@GetMapping
	public List<CartEntity> list() {
		return cartService.list();
	}
	
	@PostMapping
	public CartEntity create(@RequestBody CreateCartDto dto) throws ClientNotFoundException {
		return cartService.create(dto);
	}
	
}
