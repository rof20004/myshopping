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

@Component
public class CartBuilders {

	public static CartEntity buildEntityFromCreateCartDto(CreateCartDto dto, ClientEntity client) {
		return CartEntity.builder()
				.client(client)
				.createdAt(LocalDateTime.now())
				.status(CartStatus.PENDING)
				.build();
	}

	public static List<CartDto> buildDtoListFromEntityList(List<CartEntity> carts) {
		return carts.stream()
				.map(cart -> CartDto.builder()
								.id(cart.getId())
								.client(cart.getClient().getName())
								.total(cart.getTotal())
								.items(ItemBuilders.buildDtoListFromEntityList(cart.getItems()))
								.build()
				).collect(Collectors.toList());
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
