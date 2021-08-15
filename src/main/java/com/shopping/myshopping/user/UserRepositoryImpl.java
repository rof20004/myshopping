package com.shopping.myshopping.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cleanarch.user.domain.User;
import br.com.cleanarch.user.domain.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository<User, String> {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User findByCpf(String cpf) {
		var userModel = entityManager.find(UserModel.class, cpf);
		return new User(userModel.getCpf(), userModel.getName());
	}

	@Override
	public void save(User user) {
		var userModel = UserModel.builder()
				.cpf(user.getCpf())
				.name(user.getName())
				.build();
		
		entityManager.persist(userModel);
	}
	

}
