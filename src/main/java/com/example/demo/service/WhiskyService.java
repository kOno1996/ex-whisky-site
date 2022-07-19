package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Whisky;
import com.example.demo.repository.WhiskyRepository;

@Service
public class WhiskyService {
	@Autowired
	private WhiskyRepository whiskyRepository;
	
	public List<Whisky> whiskyList(){
		return whiskyRepository.whiskyList();
	}
}
