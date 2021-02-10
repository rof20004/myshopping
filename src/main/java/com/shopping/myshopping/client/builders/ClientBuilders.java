package com.shopping.myshopping.client.builders;

import org.springframework.stereotype.Component;

import com.shopping.myshopping.address.builders.AddressBuilders;
import com.shopping.myshopping.client.dtos.ClientDto;
import com.shopping.myshopping.client.dtos.CreateClientDto;
import com.shopping.myshopping.client.entities.ClientEntity;

@Component
public class ClientBuilders {

	public static ClientEntity buildEntityFromCreateClientDto(CreateClientDto dto) {
		return ClientEntity.builder().name(dto.getName()).cpf(dto.getCpf()).phone(dto.getPhone()).email(dto.getEmail())
				.address(AddressBuilders.buildEntityFromCreateAddressDto(dto.getAddress())).build();
	}

	public static ClientDto buildDtoFromEntity(ClientEntity client) {
		return ClientDto.builder().name(client.getName()).cpf(client.getCpf()).phone(client.getPhone())
				.email(client.getEmail()).address(AddressBuilders.buildDtoFromEntity(client.getAddress())).build();
	}

}
