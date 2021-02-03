package com.shopping.myshopping.product;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.myshopping.product.entities.ProductEntity;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	@GetMapping
	public List<ProductEntity> list() {
		return productService.list();
	}
	
	@PostMapping
	public ProductEntity create(@RequestBody ProductEntity product) {
		return productService.create(product);
	}
	
}
