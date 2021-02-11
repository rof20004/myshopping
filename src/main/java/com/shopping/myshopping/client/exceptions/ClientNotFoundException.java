package com.shopping.myshopping.client.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClientNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ClientNotFoundException(String message) {
		super(message);
	}

}
