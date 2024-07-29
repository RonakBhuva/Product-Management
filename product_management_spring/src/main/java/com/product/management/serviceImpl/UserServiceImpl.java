package com.product.management.serviceImpl;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.product.management.dto.UserDto;
import com.product.management.entities.User;
import com.product.management.repositories.UserRepository;
import com.product.management.role.Role;
import com.product.management.services.UserService;
import com.product.management.utils.AppUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User save(User user) {
		user.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
		return repository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public User registrationOfUser(UserDto userDto) {
		return repository.save(mapDtoToUserEntity(userDto));
	}

	private User mapDtoToUserEntity(UserDto userDto) {
		return new User(userDto.getUserName(), Base64.getEncoder().encodeToString(userDto.getPassword().getBytes()),
				Role.USER, AppUtils.getCurrentMillis());
	}

	@EventListener(ApplicationReadyEvent.class)
	public void saveAdmin() {
		System.out.println("Admin Saved");
		User user = findByUsername("Admin");
		if (user == null)
			repository.save(new User("Admin", Base64.getEncoder().encodeToString("Admin@123".getBytes()), Role.ADMIN,
					AppUtils.getCurrentMillis()));
	}

}
