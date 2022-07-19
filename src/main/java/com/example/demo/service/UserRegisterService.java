package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRegisterRepository;

@Service
public class UserRegisterService {
	@Autowired
	private UserRegisterRepository userRegisterRepository;
	
	public void userRegister(User user) {
		userRegisterRepository.userRegister(user);
	}
}
