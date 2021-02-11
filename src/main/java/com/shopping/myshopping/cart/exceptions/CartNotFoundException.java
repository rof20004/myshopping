package com.shopping.myshopping.cart.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CartNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CartNotFoundException(String message) {
		super(message);
	}

}
