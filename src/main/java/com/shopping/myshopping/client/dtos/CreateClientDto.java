package com.shopping.myshopping.client.dtos;

import com.shopping.myshopping.address.dtos.CreateAddressDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateClientDto {

	private String name;
	private String cpf;
	private String phone;
	private String email;
	private CreateAddressDto address;
	
}
