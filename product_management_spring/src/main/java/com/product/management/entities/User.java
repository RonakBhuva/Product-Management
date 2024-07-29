package com.product.management.entities;

import com.product.management.role.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String username;
	private String password;

	@Enumerated(EnumType.ORDINAL)
	private Role role;

	@Column(name = "createdon")
	private Long createdOn;

	public User(String username, String password, Role role, Long createdOn) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.createdOn = createdOn;
	}

}
