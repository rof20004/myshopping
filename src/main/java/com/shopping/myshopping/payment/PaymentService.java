package com.shopping.myshopping.payment;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.myshopping.cart.CartService;
import com.shopping.myshopping.cart.entities.CartEntity;
import com.shopping.myshopping.cart.enums.CartStatus;
import com.shopping.myshopping.payment.dto.PaymentDto;
import com.shopping.myshopping.payment.entities.PaymentEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

	private final PaymentRepository paymentRepository;
	private final CartService cartService;
	
	public List<PaymentEntity> list() {
		return paymentRepository.findAll();
	}
	
	public PaymentEntity create(PaymentDto dto) {
		CartEntity cart = cartService.findById(dto.getCart().getId());
		cart.setStatus(CartStatus.COMPLETED);
		
		PaymentEntity entity = PaymentEntity.builder()
			.date(LocalDateTime.now())
			.cart(cart)
			.build();
		
		return paymentRepository.save(entity);
	}
	
}
