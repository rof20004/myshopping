package com.shopping.myshopping.address.builders;

import org.springframework.stereotype.Component;

import com.shopping.myshopping.address.dtos.AddressDto;
import com.shopping.myshopping.address.dtos.CreateAddressDto;
import com.shopping.myshopping.address.entities.AddressEntity;

@Component
public class AddressBuilders {
	
	private AddressBuilders() {}

	public static AddressEntity buildEntityFromCreateAddressDto(CreateAddressDto dto) {
		return AddressEntity.builder().street(dto.getStreet()).number(dto.getNumber()).build();
	}

	public static AddressDto buildDtoFromEntity(AddressEntity address) {
		return AddressDto.builder().id(address.getId()).street(address.getStreet()).number(address.getNumber()).build();
	}

}
