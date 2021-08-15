package com.shopping.myshopping;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shopping.myshopping.cart.exceptions.CartNotFoundException;
import com.shopping.myshopping.client.exceptions.ClientNotFoundException;
import com.shopping.myshopping.product.exceptions.ProductNotFoundException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private ApplicationError buildApplicationError(RuntimeException e) {
		return ApplicationError.builder()
				.timestamp(LocalDateTime.now())
				.message(e.getMessage())
				.build();
	}

	@ExceptionHandler(value = ClientNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ApplicationError handleClientNotFoundException(ClientNotFoundException e) {
		return buildApplicationError(e);
	}
	
	@ExceptionHandler(value = ProductNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ApplicationError handleProductNotFoundException(ProductNotFoundException e) {
		return buildApplicationError(e);
	}
	
	@ExceptionHandler(value = CartNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ApplicationError handleCartNotFoundException(CartNotFoundException e) {
		return buildApplicationError(e);
	}
	
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class ApplicationError {
	
	private LocalDateTime timestamp;
	private String message;
	
}