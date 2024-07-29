package com.product.management.services;

import com.product.management.dto.UserDto;
import com.product.management.entities.User;

public interface UserService {

	public User registrationOfUser(UserDto userDto);

	public User save(User user);

	public User findByUsername(String username);

}
