package com.shopping.myshopping.cart.dtos;

import java.util.List;

import com.shopping.myshopping.item.dtos.ItemDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDto {

	private Long id;
	private String client;
	private Double total;
	private List<ItemDto> items;
	
}
