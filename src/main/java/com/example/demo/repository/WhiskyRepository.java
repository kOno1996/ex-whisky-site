package com.example.demo.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Whisky;

@Repository
public class WhiskyRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Whisky> WHISKY_ROW_MAPPER = (rs, i) -> {
		Whisky whisky = new Whisky();
		whisky.setId(rs.getInt("id"));
		// whisky.setName(rs.getString("name"));
		whisky.setBrand(rs.getString("brand"));
		// whisky.setProductingArea(rs.getString("producting_area"));
		// whisky.setClassification(rs.getString("classification"));
		whisky.setPrice(rs.getInt("price"));
		// whisky.setAlcoholContent(rs.getInt("alcohol_content"));
		// whisky.setManufacturer(rs.getString("manufacturer"));
		whisky.setMaturityYears(rs.getInt("maturity_years"));
		// whisky.setCapacity(rs.getInt("capacity"));
		return whisky;
	};

	public List<Whisky> whiskyList() throws IOException {
		StringBuilder sql = new StringBuilder();

		// HTMLファイルを読み込む
		InputStream is = new ClassPathResource("static/css/jsoup.html").getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String line;
		String lines = "";
		List<Whisky> names = new ArrayList<Whisky>();
		

		// 1行ずつファイルを読み込む

		while ((line = br.readLine()) != null) {
			lines += line;
		}
		
		
		Document doc = Jsoup.parse(lines, "UTF-8");
		//System.out.println("\n\n\n\n\n\n\n\n" + doc);

		// aタグ要素のテキストを取り出す
		Elements elements = doc.select("a");
		for (Element element : elements) {
			Whisky whisky = new Whisky();
			whisky.setName(element.text());
			names.add(whisky);
		}

		sql.append("SELECT id, brand, price, maturity_years FROM whisky");
		
		return template.query(sql.toString(), WHISKY_ROW_MAPPER);
		//return names;
	}
}
