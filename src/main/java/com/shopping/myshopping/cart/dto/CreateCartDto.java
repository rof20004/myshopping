package com.shopping.myshopping.cart.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCartDto {

	private long clientId;
	private List<CreateItemDto> products;
	
}
