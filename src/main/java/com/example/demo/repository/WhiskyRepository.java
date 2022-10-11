package com.example.demo.repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
		whisky.setId(rs.getInt("id"));
		//whisky.setName(rs.getString("name"));
		whisky.setBrand(rs.getString("brand"));
		//whisky.setProductingArea(rs.getString("producting_area"));
		//whisky.setClassification(rs.getString("classification"));
		whisky.setPrice(rs.getInt("price"));
		//whisky.setAlcoholContent(rs.getInt("alcohol_content"));
		//whisky.setManufacturer(rs.getString("manufacturer"));
		whisky.setMaturityYears(rs.getInt("maturity_years"));
		//whisky.setCapacity(rs.getInt("capacity"));
		return whisky;
	};
	
	public List<Whisky> whiskyList() throws IOException{
		StringBuilder sql = new StringBuilder();
		Document doc = Jsoup.parse(new File("/jsoup.html"), "UTF-8");
		System.out.println("\n\n\n\n\n\n\n\n" + doc.html());
		sql.append("SELECT id, brand, price, maturity_years FROM whisky");
		return template.query(sql.toString(), WHISKY_ROW_MAPPER);
	}
}
