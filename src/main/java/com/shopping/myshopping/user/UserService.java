package com.shopping.myshopping.user;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.cleanarch.user.domain.User;
import br.com.cleanarch.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository<User, String> userRepository;
	
	@Transactional
	public UserDto create(UserDto dto) {
		var user = new User(dto.getCpf(), dto.getName());
		
		userRepository.save(user);
		
		return UserDto.builder()
				.cpf(user.getCpf())
				.name(user.getName())
				.build();
	}

	@Transactional
	public UserDto findByCpf(String cpf) {
		var user = userRepository.findByCpf(cpf);
		
		return UserDto.builder()
				.cpf(user.getCpf())
				.name(user.getName())
				.build();
	}
	
}
