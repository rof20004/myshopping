package com.shopping.myshopping.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.myshopping.cart.entities.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

}
