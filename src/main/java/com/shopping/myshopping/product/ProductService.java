package com.shopping.myshopping.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.myshopping.product.entities.ProductEntity;
import com.shopping.myshopping.product.exceptions.ProductNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
	
	public List<ProductEntity> list() {
		return productRepository.findAll();
	}
	
	public ProductEntity create(ProductEntity product) {
		return productRepository.save(product);
	}
	
	public ProductEntity findById(Long id) throws ProductNotFoundException {
		return productRepository.findById(id).orElseThrow(
				() -> new ProductNotFoundException(String.format("Produto #%d não encontrado", id)));
	}
	
}
