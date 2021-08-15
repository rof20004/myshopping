package com.shopping.myshopping.cart;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.myshopping.cart.builders.CartBuilders;
import com.shopping.myshopping.cart.dtos.CartDto;
import com.shopping.myshopping.cart.dtos.CreateCartDto;
import com.shopping.myshopping.cart.entities.CartEntity;
import com.shopping.myshopping.cart.exceptions.CartNotFoundException;
import com.shopping.myshopping.client.ClientService;
import com.shopping.myshopping.client.entities.ClientEntity;
import com.shopping.myshopping.item.builders.ItemBuilders;
import com.shopping.myshopping.item.entities.ItemEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {

	private final CartRepository cartRepository;
	private final ClientService clientService;

	public List<CartDto> list() {
		List<CartEntity> carts = cartRepository.findAll();
		
		return CartBuilders.buildDtoListFromEntityList(carts);
	}

	public CartDto create(CreateCartDto dto) {
		ClientEntity client = clientService.findById(dto.getClient());

		CartEntity cart = CartBuilders.buildEntityFromCreateCartDto(client);

		List<ItemEntity> items = ItemBuilders.buildEntityListFromCreateCartDto(dto, cart);
		cart.setItems(items);

		// TODO: create business logic to handle product quantity
		double total = items.stream().filter(item -> item.getQuantity() > 0).mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
		cart.setTotal(total);

		cartRepository.save(cart);

		return CartBuilders.buildDtoFromEntity(cart);
	}

	public CartEntity findById(Long id) {
		return cartRepository.findById(id).orElseThrow(() -> new CartNotFoundException("Cart not found"));
	}

}
