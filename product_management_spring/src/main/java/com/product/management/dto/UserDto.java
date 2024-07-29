package com.product.management.dto;

import com.product.management.role.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	private String userName;
	private String password;
	private Role role;

}
