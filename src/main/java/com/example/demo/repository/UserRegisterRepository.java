package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;

@Repository
public class UserRegisterRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public void userRegister(User user) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO users(name, mail, password, ");
		sql.append("gender, age, area)VALUES(");
		sql.append(":name, :mail, :password, :gender, ");
		sql.append(":age, :area)");
		template.update(sql.toString(), param);
	}
}
