package com.shopping.myshopping.payment;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.myshopping.payment.dto.PaymentDto;
import com.shopping.myshopping.payment.entities.PaymentEntity;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

	private final PaymentService paymentService;
	
	@GetMapping
	public List<PaymentEntity> list() {
		return paymentService.list();
	}
	
	@PostMapping
	public PaymentEntity create(@RequestBody PaymentDto dto) {
		return paymentService.create(dto);
	}
	
}
