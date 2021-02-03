package com.shopping.myshopping.client;

import java.util.List;

import org.springframework.stereotype.Service;

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

	public ClientEntity create(ClientEntity client) {
		return clientRepository.save(client);
	}

	public ClientEntity findById(Long id) throws ClientNotFoundException {
		return clientRepository.findById(id).orElseThrow(
				() -> new ClientNotFoundException("Cliente não encontrado, favor realizar cadastro antes"));
	}

}
