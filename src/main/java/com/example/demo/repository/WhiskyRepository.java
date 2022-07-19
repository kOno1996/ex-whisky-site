package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Whisky;

@Repository
public class WhiskyRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Whisky> WHISKY_ROW_MAPPER = (rs, i)->{
		Whisky whisky = new Whisky();
		whisky.setNameAll(rs.getString("name_all"));
		whisky.setName(rs.getString("name"));
		whisky.setProductingArea(rs.getString("producting_area"));
		whisky.setClassification(rs.getString("classification"));
		whisky.setPrice(rs.getInt("price"));
		whisky.setAlcoholContent(rs.getInt("alcohol_content"));
		whisky.setManufacturer(rs.getString("manufacturer"));
		whisky.setMaturityYears(rs.getInt("maturity_years"));
		whisky.setCapacity(rs.getInt("capacity"));
		return whisky;
	};
	
	public List<Whisky> whiskyList(){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM whisky");
		return template.query(sql.toString(), WHISKY_ROW_MAPPER);
	}
}
