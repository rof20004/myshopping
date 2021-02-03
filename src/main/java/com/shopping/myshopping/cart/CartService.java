package com.shopping.myshopping.cart;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shopping.myshopping.cart.dto.CreateCartDto;
import com.shopping.myshopping.cart.entities.CartEntity;
import com.shopping.myshopping.cart.entities.ItemEntity;
import com.shopping.myshopping.cart.enums.CartStatus;
import com.shopping.myshopping.cart.exceptions.CartNotFoundException;
import com.shopping.myshopping.client.ClientService;
import com.shopping.myshopping.client.entities.ClientEntity;
import com.shopping.myshopping.client.exceptions.ClientNotFoundException;
import com.shopping.myshopping.product.ProductService;
import com.shopping.myshopping.product.entities.ProductEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {

	private final CartRepository cartRepository;
	private final ClientService clientService;
	private final ProductService productService;
	
	public List<CartEntity> list() {
		return cartRepository.findAll();
	}
	
	public CartEntity create(CreateCartDto dto) throws ClientNotFoundException {
		ClientEntity client = clientService.findById(dto.getClientId());
		
		CartEntity cart = CartEntity.builder()
				.client(client)
				.createdAt(LocalDateTime.now())
				.status(CartStatus.PENDING)
				.build();
		
		List<ItemEntity> items = dto.getProducts().stream()
				.map(item -> {
					try {
						ProductEntity product = productService.findById(item.getProductId());
						return ItemEntity.builder()
								.cart(cart)
								.product(product.getDescription())
								.price(product.getPrice())
								.quantity(item.getQuantity())
								.build();
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}).collect(Collectors.toList());
		
		// TODO: adicionar regra de negócio para verificar quantidade do produto
		double total = items.stream().filter(item -> item.getQuantity() > 0).mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
		cart.setTotal(total);
		cart.setItems(items);
		
		return cartRepository.save(cart);
	}
	
	public CartEntity findById(Long id) throws CartNotFoundException {
		return cartRepository.findById(id).orElseThrow(
				() -> new CartNotFoundException("Carrinho não encontrado"));
	}
	
}
