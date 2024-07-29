package com.product.management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.management.dto.UserDto;
import com.product.management.entities.User;
import com.product.management.services.UserService;
import com.product.management.utils.JwtUtil;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	private UserService userService;

//	@Autowired
//	private AuthenticationManager authenticationManager;

//	@Autowired
//	private UserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/register")
	public User register(@RequestBody UserDto user) {
		return userService.registrationOfUser(user);
	}

	@PostMapping("/login")
	public String login(@RequestBody User user) {
//		authenticationManager
//				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
		return jwtUtil.generateToken(user.getUsername());
	}
}
