package com.shopping.myshopping.item.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {

	private Long id;
	private String product;
	private Integer quantity;
	private Double price;
	
}
