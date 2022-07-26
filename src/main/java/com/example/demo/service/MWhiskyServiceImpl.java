package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.MWhisky;
import com.example.demo.repository.WhiskyMapper;

@Service
public class MWhiskyServiceImpl implements MWhiskyService{
	@Autowired
	private WhiskyMapper mapper;
	
	@Override
	public MWhisky getWhisky(Integer id) {
		return mapper.findOne(id);
	}
}
