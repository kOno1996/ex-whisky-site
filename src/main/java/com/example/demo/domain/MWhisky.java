package com.example.demo.domain;

import lombok.Data;

@Data
public class MWhisky {
	private Integer id;
	private String name;
	private String brand;
	private String productingArea;
	private String classification;
	private Integer price;
	private Integer alcoholContent;
	private String manufacturer;
	private Integer maturityYears;
	private Integer capacity;
}
