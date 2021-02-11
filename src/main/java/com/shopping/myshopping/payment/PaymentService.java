package com.shopping.myshopping.payment;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.myshopping.cart.CartService;
import com.shopping.myshopping.cart.entities.CartEntity;
import com.shopping.myshopping.cart.enums.CartStatus;
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
	
	public PaymentEntity create(PaymentEntity payment) {
		CartEntity cart = cartService.findById(payment.getCart().getId());
		cart.setStatus(CartStatus.COMPLETED);

		payment.setDate(LocalDateTime.now());
		payment.setCart(cart);
		
		return paymentRepository.save(payment);
	}
	
}
