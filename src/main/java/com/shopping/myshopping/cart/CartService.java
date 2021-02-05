package com.shopping.myshopping.cart;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.myshopping.cart.builders.CartBuilders;
import com.shopping.myshopping.cart.dtos.CreateCartDto;
import com.shopping.myshopping.cart.entities.CartEntity;
import com.shopping.myshopping.cart.entities.ItemEntity;
import com.shopping.myshopping.cart.exceptions.CartNotFoundException;
import com.shopping.myshopping.client.ClientService;
import com.shopping.myshopping.client.entities.ClientEntity;
import com.shopping.myshopping.client.exceptions.ClientNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {

	private final CartRepository cartRepository;
	private final ClientService clientService;
	
	public List<CartEntity> list() {
		return cartRepository.findAll();
	}
	
	public CartEntity create(CreateCartDto dto) throws ClientNotFoundException {
		ClientEntity client = clientService.findById(dto.getClientId());
		
		CartEntity cart = CartBuilders.createCartDtoToEntity(dto, client);
		
		List<ItemEntity> items = CartBuilders.createCartDtoBuildItemsEntity(dto, cart);
		cart.setItems(items);
		
		double total = CartBuilders.createCartDtoCalculateTotal(items);
		cart.setTotal(total);
		
		return cartRepository.save(cart);
	}
	
	public CartEntity findById(Long id) throws CartNotFoundException {
		return cartRepository.findById(id).orElseThrow(
				() -> new CartNotFoundException("Carrinho não encontrado"));
	}
	
}
