package com.shopping.myshopping.user;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService service;
	
	@GetMapping("/{cpf}")
	public UserDto get(@PathVariable("cpf") String cpf) {
		return service.findByCpf(cpf);
	}
	
	@Transactional
	@PostMapping
	public UserDto create(@RequestBody UserDto dto) {
		return service.create(dto);
	}
	
}
