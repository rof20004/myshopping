package com.shopping.myshopping.cart.builders;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.shopping.myshopping.cart.dtos.CartDto;
import com.shopping.myshopping.cart.dtos.CreateCartDto;
import com.shopping.myshopping.cart.entities.CartEntity;
import com.shopping.myshopping.cart.enums.CartStatus;
import com.shopping.myshopping.client.entities.ClientEntity;
import com.shopping.myshopping.item.builders.ItemBuilders;
import com.shopping.myshopping.item.dtos.ItemDto;

@Component
public class CartBuilders {

	public static CartEntity buildEntityFromCreateCartDto(CreateCartDto dto, ClientEntity client) {
		CartEntity entity = CartEntity.builder().client(client).createdAt(LocalDateTime.now())
				.status(CartStatus.PENDING).build();
		return entity;
	}

	public static List<CartDto> buildDtoListFromEntityList(List<CartEntity> carts) {
		return carts.stream()
				.map(cart -> CartDto.builder().id(cart.getId()).client(cart.getClient().getName())
						.total(cart.getTotal())
						.items(cart.getItems().stream()
								.map(item -> ItemDto.builder().id(item.getId()).product(item.getProduct())
										.price(item.getPrice()).quantity(item.getQuantity()).build())
								.collect(Collectors.toList()))
						.build())
				.collect(Collectors.toList());
	}
	
	public static CartDto buildDtoFromEntity(CartEntity cart) {
		return CartDto.builder()
				.id(cart.getId())
				.client(cart.getClient().getName())
				.total(cart.getTotal())
				.items(ItemBuilders.buildDtoListFromEntityList(cart.getItems()))
				.build();
	}

}
