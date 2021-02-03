package com.shopping.myshopping.product.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundException(String message) {
		super(message);
	}

}
