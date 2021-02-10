package com.shopping.myshopping.client;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.myshopping.client.dtos.ClientDto;
import com.shopping.myshopping.client.dtos.CreateClientDto;
import com.shopping.myshopping.client.entities.ClientEntity;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

	private final ClientService clientService;
	
	@GetMapping
	public List<ClientEntity> list() {
		return clientService.list();
	}
	
	@PostMapping
	public ClientDto create(@RequestBody CreateClientDto dto) {
		return clientService.create(dto);
	}
	
}
