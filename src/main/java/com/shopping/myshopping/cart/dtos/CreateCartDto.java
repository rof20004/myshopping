package com.shopping.myshopping.cart.dtos;

import java.util.List;

import com.shopping.myshopping.item.dtos.CreateItemDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCartDto {

	private Long client;
	private List<CreateItemDto> products;
	
}
