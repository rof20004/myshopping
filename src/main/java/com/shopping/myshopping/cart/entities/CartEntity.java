package com.shopping.myshopping.cart.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.shopping.myshopping.cart.enums.CartStatus;
import com.shopping.myshopping.client.entities.ClientEntity;
import com.shopping.myshopping.item.entities.ItemEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "total")
	private Double total;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private CartStatus status;
	
	@OneToOne
	@JoinColumn(name = "client_id")
	private ClientEntity client;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.PERSIST)
	private List<ItemEntity> items;
	
}
