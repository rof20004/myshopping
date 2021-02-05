package com.shopping.myshopping.cart.builders;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.myshopping.cart.dtos.CreateCartDto;
import com.shopping.myshopping.cart.entities.CartEntity;
import com.shopping.myshopping.cart.entities.ItemEntity;
import com.shopping.myshopping.cart.enums.CartStatus;
import com.shopping.myshopping.client.entities.ClientEntity;
import com.shopping.myshopping.product.ProductService;
import com.shopping.myshopping.product.entities.ProductEntity;

@Component
public class CartBuilders {

	private static ProductService productService;
	
	@Autowired
	public CartBuilders(ProductService productService) {
		CartBuilders.productService = productService;
	}

	public static CartEntity createCartDtoToEntity(CreateCartDto dto, ClientEntity client) {
		CartEntity entity = CartEntity.builder().client(client).createdAt(LocalDateTime.now())
				.status(CartStatus.PENDING).build();
		return entity;
	}

	public static List<ItemEntity> createCartDtoBuildItemsEntity(CreateCartDto dto, CartEntity cart) {
		return dto.getProducts().stream().map(item -> {
			try {
				ProductEntity product = productService.findById(item.getProductId());
				return ItemEntity.builder().cart(cart).product(product.getDescription()).price(product.getPrice())
						.quantity(item.getQuantity()).build();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}).collect(Collectors.toList());
	}

	public static double createCartDtoCalculateTotal(List<ItemEntity> items) {
		return items.stream().filter(item -> item.getQuantity() > 0)
				.mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
	}

}
