package com.shopping.myshopping.payment.dto;

import java.time.LocalDateTime;

import com.shopping.myshopping.cart.entities.CartEntity;
import com.shopping.myshopping.payment.enums.PaymentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {

	private Long id;
	private LocalDateTime date;
	private PaymentType type;
	private CartEntity cart;
	
}
