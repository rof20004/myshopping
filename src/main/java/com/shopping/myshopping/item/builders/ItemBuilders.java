package com.shopping.myshopping.item.builders;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.myshopping.cart.dtos.CreateCartDto;
import com.shopping.myshopping.cart.entities.CartEntity;
import com.shopping.myshopping.item.dtos.ItemDto;
import com.shopping.myshopping.item.entities.ItemEntity;
import com.shopping.myshopping.product.ProductService;
import com.shopping.myshopping.product.entities.ProductEntity;

@Component
public class ItemBuilders {

	private static ProductService productService;

	@Autowired
	public ItemBuilders(ProductService productService) {
		ItemBuilders.productService = productService;
	}

	public static List<ItemEntity> buildEntityListFromCreateCartDto(CreateCartDto dto, CartEntity cart) {
		return dto.getProducts().stream().map(item -> {
			try {
				ProductEntity product = productService.findById(item.getProduct());
				return ItemEntity.builder().cart(cart).product(product.getDescription()).price(product.getPrice())
						.quantity(item.getQuantity()).build();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}).collect(Collectors.toList());
	}

	public static List<ItemDto> buildDtoListFromEntityList(List<ItemEntity> items) {
		return items.stream().map(item -> ItemDto.builder().id(item.getId()).product(item.getProduct())
				.price(item.getPrice()).quantity(item.getQuantity()).build()).collect(Collectors.toList());
	}

}
