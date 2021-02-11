package com.shopping.myshopping.client;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.myshopping.client.builders.ClientBuilders;
import com.shopping.myshopping.client.dtos.ClientDto;
import com.shopping.myshopping.client.dtos.CreateClientDto;
import com.shopping.myshopping.client.entities.ClientEntity;
import com.shopping.myshopping.client.exceptions.ClientNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {

	private final ClientRepository clientRepository;

	public List<ClientEntity> list() {
		return clientRepository.findAll();
	}

	public ClientDto create(CreateClientDto dto) {
		ClientEntity client = ClientBuilders.buildEntityFromCreateClientDto(dto);
		
		clientRepository.save(client);
		
		return ClientBuilders.buildDtoFromEntity(client);
	}

	public ClientEntity findById(Long id) {
		return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client not found, please register into application before buy"));
	}

}
