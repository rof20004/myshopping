package com.shopping.myshopping.product;

import com.shopping.myshopping.product.dto.ProductDto;
import com.shopping.myshopping.product.entities.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	public ProductEntity create(@RequestBody ProductDto dto) {
		return productService.create(dto);
	}
	
}
