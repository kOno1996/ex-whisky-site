package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.MWhisky;

@Mapper
public interface WhiskyMapper {
	public MWhisky findOne(Integer id);
}
